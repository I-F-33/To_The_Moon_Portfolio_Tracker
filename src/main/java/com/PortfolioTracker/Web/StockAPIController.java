package com.PortfolioTracker.Web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.PortfolioTracker.DTO.CryptoListing;
import com.PortfolioTracker.DTO.DailyCryptoResponse;
import com.PortfolioTracker.DTO.DailyStockResponse;
import com.PortfolioTracker.DTO.StockListing;
import com.PortfolioTracker.Service.APIService;
import com.PortfolioTracker.Service.FileService;

@RestController
public class StockAPIController {

	@Autowired
	APIService APIService;
	
	@Autowired
	FileService fileService;
	
	@GetMapping("/fetchDailyData/stock/{symbol}")
	public ResponseEntity<DailyStockResponse> fetchDailyStockData(@PathVariable String symbol) {
		return APIService.fetchDailyStockData(symbol);
	}
	
	@GetMapping("/fetchDailyData/crypto/{symbol}")
	public ResponseEntity<DailyCryptoResponse> fetchDailyCryptoData(@PathVariable String symbol) {
		return APIService.fetchDailyCryptoData(symbol);
	}
	
	@GetMapping(value = "/getStockList", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<StockListing> fetchStockList() {
		return fileService.parseStockCsvFileToList();
	}
	
	@GetMapping("/getCryptoList")
	public List<CryptoListing> fetchCryptoList() {
		return fileService.parseCryptoCsvFileToList();
	}
	
	
	
	
	
	
}
