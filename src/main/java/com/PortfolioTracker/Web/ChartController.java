package com.PortfolioTracker.Web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.PortfolioTracker.DTO.CryptoListing;
import com.PortfolioTracker.DTO.Search;
import com.PortfolioTracker.DTO.StockListing;
import com.PortfolioTracker.Domain.User;
import com.PortfolioTracker.Service.FileService;

@Controller
public class ChartController {

	@Autowired
	FileService fileService;
	
	@GetMapping("/chart/{name}")
	public String fetchAssetChart(@AuthenticationPrincipal User user, @PathVariable String name, ModelMap model) {
		List<CryptoListing> cryptoList = fileService.parseCryptoCsvFileToList();
		List<StockListing> stockList = fileService.parseStockCsvFileToList();
		
		System.out.println(name);
		model.put("user", user);
		
		//conditional checks if list of crypto contains crypto with matching asset name then fetches the matching crypto
		//and adds to model
		if(cryptoList.stream()
					 .anyMatch(crypto -> crypto.getName().equalsIgnoreCase(name))) {
			Optional<CryptoListing> matchingCrypto = cryptoList.stream()
					  .filter(crypto -> crypto.getName().equalsIgnoreCase(name))
					  .findFirst();
			
			model.put("crypto", matchingCrypto.get());
			
			return "chart.html";
			
		} else if(stockList.stream()
							.anyMatch(stock -> stock.getName().equalsIgnoreCase(name))) {
			Optional<StockListing> matchingStock = stockList.stream()
					 .filter(stock -> stock.getName().equalsIgnoreCase(name))
					 .findFirst();
				
				model.put("stock", matchingStock.get());
				
				return "chart.html";
		} else {
			model.put("search", new Search());
			return "dashboard.html";
		}
	}
}
