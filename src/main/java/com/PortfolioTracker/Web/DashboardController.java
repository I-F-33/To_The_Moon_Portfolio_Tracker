package com.PortfolioTracker.Web;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.Stack;

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
	
	@GetMapping("/dashboard/stock/chart/{name}")
	public String fetchAssetChart(@AuthenticationPrincipal User user, @PathVariable String name, ModelMap model) {
		List<CryptoListing> cryptoList = fileService.parseCryptoCsvFileToList();
		List<StockListing> stockList = fileService.parseStockCsvFileToList();
		
		System.out.println(name);
		model.put("user", user);
		Search latestSearch = searches.pop();
		
		//conditional checks if list of crypto contains crypto with matching asset name then fetches the matching crypto
		//and adds to model
		
		//models puts latest search to check what type of chart should be displayed
		if(cryptoList.stream()
					 .anyMatch(crypto -> crypto.getName().equalsIgnoreCase(name))) {
			Optional<CryptoListing> matchingCrypto = cryptoList.stream()
					  .filter(crypto -> crypto.getName().equalsIgnoreCase(name))
					  .findFirst();
			
			
			
			model.put("crypto", matchingCrypto.get());
			model.put("search", latestSearch);
			
			return "chart.html";
			
			//conditional checks if list of stocks contains stock with matching asset name then fetches the matching stock
			//and adds to model
			
			//models puts latest search to check what type of chart should be displayed
		} else if(stockList.stream()
							.anyMatch(stock -> stock.getName().equalsIgnoreCase(name))) {
			Optional<StockListing> matchingStock = stockList.stream()
					 .filter(stock -> stock.getName().equalsIgnoreCase(name))
					 .findFirst();
				
				System.out.println(matchingStock);
				model.put("stock", matchingStock.get());
				model.put("search", latestSearch);
				searches.push(latestSearch);
				
				return "stock_chart.html";
		} else {
			model.put("search", new Search());
			return "dashboard.html";
		}
	}
	
	@GetMapping("/dashboard/myPortfolio/{userId}/stocks")
	public String getStockPortfolio(@PathVariable Long userId, @AuthenticationPrincipal User user, ModelMap model) {
		List<StockListing> userStocks = userService.fetchAllUserStocks(userId);
		
		if(userStocks.isEmpty()) {
			return "redirect:/dashboard";
		}
		
		model.put("stocks", userStocks);
		model.put("user", user);
		
		return "stocks.html";
	}
	
	
	
	
}
