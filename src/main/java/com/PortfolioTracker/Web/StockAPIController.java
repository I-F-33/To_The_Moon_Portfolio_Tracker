package com.PortfolioTracker.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PortfolioTracker.DTO.DailyStockResponse;
import com.PortfolioTracker.DTO.SearchEndpointResponse;
import com.PortfolioTracker.Service.StockAPIService;

@RestController
public class StockAPIController {

	@Autowired
	StockAPIService stockService;
	
	@GetMapping("/myportfolio/stock")
	public ResponseEntity<DailyStockResponse> fetchDailyStockData(String symbol) {
		return stockService.fetchDailyStockData(symbol);
		
	}
	
	@GetMapping("/bestMatches")
	public ResponseEntity<SearchEndpointResponse> fetchBestMatchForKeyword(String keyword) {
		return stockService.fetchBestReponseForKeyword(keyword);
	}
	
	
	
	
	
	
}
