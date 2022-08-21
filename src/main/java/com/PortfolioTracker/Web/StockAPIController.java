package com.PortfolioTracker.Web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PortfolioTracker.DTO.CryptoListing;
import com.PortfolioTracker.DTO.DailyStockResponse;
import com.PortfolioTracker.DTO.StockListing;
import com.PortfolioTracker.Service.FileService;
import com.PortfolioTracker.Service.APIService;

@RestController
public class StockAPIController {

	@Autowired
	APIService APIService;
	
	@Autowired
	FileService fileService;
	
	@GetMapping("/myportfolio/stock")
	public ResponseEntity<DailyStockResponse> fetchDailyStockData(String symbol) {
		return APIService.fetchDailyStockData(symbol);
		
	}
	
	@GetMapping("/getStockList")
	public List<StockListing> fetchStockList() {
		return fileService.parseStockCsvFileToList();
	}
	
	@GetMapping("/getCryptoList")
	public List<CryptoListing> fetchCryptoList() {
		return fileService.parseCryptoCsvFileToList();
	}
	
	
	
	
	
	
}
