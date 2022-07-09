package com.PortfolioTracker.Web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.PortfolioTracker.DTO.StockEODDataResponse;
import com.PortfolioTracker.Service.StockAPIService;

@RestController
public class StockAPIController {

	@Autowired
	StockAPIService stockService;
	
	@GetMapping("/myPortfolio/{stockID}/chart")
	public ResponseEntity<StockEODDataResponse> getStockChart(@PathVariable long stockId, 
			String symbols, Optional<String> dateFrom, Optional<String> dateTo) 
	{
		return stockService.fetchCustomEODDataResponse(symbols, dateFrom, dateTo);
	}
	
	
	
	
}
