package com.PortfolioTracker.Web;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.PortfolioTracker.DTO.CryptoListing;
import com.PortfolioTracker.DTO.Search;
import com.PortfolioTracker.DTO.StockListing;
import com.PortfolioTracker.Domain.Crypto;
import com.PortfolioTracker.Domain.Stock;
import com.PortfolioTracker.Domain.User;
import com.PortfolioTracker.Service.FileService;
import com.PortfolioTracker.Service.UserService;

@Controller
public class DashboardController {

	@Autowired
	FileService fileService;
	
	@Autowired
	UserService userService;
	
	
	private Stack<Search> searches = new Stack<Search>();
	
	
	@GetMapping("/dashboard")
	public String displayDashboard(@AuthenticationPrincipal User user, ModelMap model) {
		model.put("user", user);
		model.put("search", new Search());
		return "dashboard.html";
	}
	
	
	@GetMapping("/dashboard/results")
	public String displayCrpytoResults(ModelMap model, @AuthenticationPrincipal User user) {
		Search latestSearch = searches.pop();
		
		//if search category is set to crypto
		if (latestSearch.getSearchType().equals("Crypto")) {
			List<CryptoListing> matchingCrypto = fileService.fetchMatchingCrypto(latestSearch.getSearchString());
			System.out.println(matchingCrypto.size());
			model.put("cryptos", matchingCrypto);
			model.put("user", user);
			searches.push(latestSearch);
			return "results.html";
			
			//if search category is set to stock
		} else if (latestSearch.getSearchType().equals("Stock")){
			List<StockListing> matchingStocks = fileService.fetchMatchingStocks(latestSearch.getSearchString());
			System.out.println(matchingStocks.size());
			searches.push(latestSearch);
			model.put("stocks", matchingStocks);
			model.put("user", user);
			return "results.html";
		}
		//if search fails return to dashboard
		searches.push(latestSearch);
		return "redirect:/dashboard.html";
				
	}
	
	@PostMapping("/dashboard/results")
	public String displayStockResults(Search search) {
		if(search.getSearchType().equals("none")) {
			return "redirect:/dashboard";
		}
		
		if(searches.capacity() == 10) {
			searches.clear();
		}
		searches.push(search);
		System.out.println(search);
		return "redirect:/dashboard/results";
	}
	
	@GetMapping("/dashboard/chart/{userId}/{name}")
	public String fetchAssetChart(@AuthenticationPrincipal User user, @PathVariable String name, @PathVariable Long userId,ModelMap model) {
		List<CryptoListing> cryptoList = fileService.parseCryptoCsvFileToList();
		List<StockListing> stockList = fileService.parseStockCsvFileToList();
		//users stock symbols: used to check whether user has stock already saved.
		//used in conditional to display save button or not
		List<String> userStockSymbols = userService.fetchAllUserStocks(userId).stream()
																			  .map(stock -> stock.getSymbol())
																			  .collect(Collectors.toList());
		//users saved crypto symbols: used to check whether user has crypto already saved.
		//used in conditional to display save button or not
		List<String> userCryptoSymbols = userService.fetchAllUserCrypto(userId).stream()
																			   .map(crypto -> crypto.getSymbol())
																			   .collect(Collectors.toList());
		
		System.out.println(name);
		model.put("user", user);
		Search latestSearch = searches.pop();
		
		//conditional checks if list of crypto contains crypto with matching asset name then fetches the matching crypto
		//and adds to model
		
		//models puts latest search to check what type of chart should be displayed
		if(cryptoList.stream()
					 .anyMatch(crypto -> crypto.getName()
							 				   .equalsIgnoreCase(name))) {
			CryptoListing matchingCrypto = cryptoList.stream()
					  								 .filter(crypto -> crypto.getName().equalsIgnoreCase(name))
					  								 .findFirst()
					  								 .get();
			
			
			System.out.println(matchingCrypto);
			model.put("crypto", matchingCrypto);
			model.put("search", latestSearch);
			model.put("userCryptos", userCryptoSymbols);
			searches.push(latestSearch);
			
			return "crypto_chart.html";
			
			//conditional checks if list of stocks contains stock with matching asset name then fetches the matching stock
			//and adds to model
			
			//models puts latest search to check what type of chart should be displayed
		} else if(stockList.stream()
						   .anyMatch(stock -> stock.getName()
												   .equalsIgnoreCase(name))) {
			StockListing matchingStock = stockList.stream()
					 							  .filter(stock -> stock.getName().equalsIgnoreCase(name))
					 							  .findFirst()
					 							  .get();
				
				System.out.println(matchingStock);
				model.put("stock", matchingStock);
				model.put("search", latestSearch);
				model.put("userStocks", userStockSymbols);
				searches.push(latestSearch);
				
				return "stock_chart.html";
		} else {
			return "redirect:/dashboard";
		}
	}
	
	@GetMapping("/dashboard/myPortfolio/{userId}/stocks")
	public String getStockPortfolio(@PathVariable Long userId, @AuthenticationPrincipal User user, ModelMap model) {
		List<Stock> userStocks = userService.fetchAllUserStocks(userId);
		
		if(userStocks.isEmpty()) {
			return "redirect:/dashboard";
		}
		
		model.put("stocks", userStocks);
		model.put("user", user);
		
		return "my_portfolio.html";
	}
	
	@GetMapping("/dashboard/myPortfolio/{userId}/crypto")
	public String getCryptoPortfolio(@PathVariable Long userId, @AuthenticationPrincipal User user, ModelMap model) {
		List<Crypto> userCryptos = userService.fetchAllUserCrypto(userId);
		
		if(userCryptos.isEmpty()) {
			return "redirect:/dashboard";
		}
		
		model.put("cryptos", userCryptos);
		model.put("user", user);
		
		return "my_portfolio.html";
	}
	
	
	
	
}
