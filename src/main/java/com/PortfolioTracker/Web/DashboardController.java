package com.PortfolioTracker.Web;

import java.util.List;
import java.util.Stack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.PortfolioTracker.DTO.CryptoListing;
import com.PortfolioTracker.DTO.Search;
import com.PortfolioTracker.DTO.StockListing;
import com.PortfolioTracker.Domain.User;
import com.PortfolioTracker.Service.FileService;

@Controller
public class DashboardController {

	@Autowired
	FileService fileService;
	
	
	private Stack<Search> searches = new Stack<Search>();
	
	
	@GetMapping("/dashboard")
	public String displayDashboard(@AuthenticationPrincipal User user, ModelMap model) {
		model.put("user", user);
		model.put("search", new Search());
		return "dashboard.html";
	}
	
	
	@GetMapping("/dashboard/results")
	public String displayCrpytoResults(ModelMap model) {
		Search latestSearch = searches.pop();
		
		//if search category is set to crypto
		if (latestSearch.getSearchType().equals("Crypto")) {
			List<CryptoListing> matchingCrypto = fileService.fetchMatchingCrypto(latestSearch.getSearchString());
			System.out.println(matchingCrypto.size());
			model.put("cryptos", matchingCrypto);
			return "results.html";
			
			//if search category is set to stock
		} else if (latestSearch.getSearchType().equals("Stock")){
			List<StockListing> matchingStocks = fileService.fetchMatchingStocks(latestSearch.getSearchString());
			System.out.println(matchingStocks.size());
			model.put("stocks", matchingStocks);
			return "results.html";
		}
		//if search fails return to dashboard
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
	
	
}
