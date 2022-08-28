package com.PortfolioTracker.Web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.PortfolioTracker.DTO.CryptoListing;
import com.PortfolioTracker.DTO.StockListing;
import com.PortfolioTracker.Security.CustomSecurityUser;
import com.PortfolioTracker.Service.FileService;

@Controller
public class DashboardController {

	@Autowired
	FileService fileService;
		
	@GetMapping("/dashboard")
	public String displayDashboard(@AuthenticationPrincipal CustomSecurityUser user, ModelMap model) {
		model.put("user", user);
		return "dashboard.html";
	}
	
	@GetMapping("/dashboard/results/crypto/{searchString}")
	public String displayCrpytoResults(@PathVariable String searchString, ModelMap model) {
		List<CryptoListing> matchingCrypto = fileService.fetchMatchingCrypto(searchString);
		model.put("cryptos", matchingCrypto);
		return "results.html";
	}
	
	@GetMapping("/dashboard/results/stocks/{searchString}")
	public String displayStockResults(String searchString, ModelMap model) {
		List<StockListing> matchingStocks = fileService.fetchMatchingStocks(searchString);
		model.put("stocks", matchingStocks);
		return "results.html";
		
	}
	
	
}
