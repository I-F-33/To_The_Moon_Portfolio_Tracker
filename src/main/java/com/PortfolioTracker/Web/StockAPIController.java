package com.PortfolioTracker.Web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PortfolioTracker.DTO.StockEODDataResponse;
import com.PortfolioTracker.Service.StockAPIService;

@RestController
public class StockAPIController {

	@Autowired
	StockAPIService stockService;
	
	@GetMapping("/myPortfolio/chart")
	public ResponseEntity<?> getStockChart
		(String symbols, Optional<String> dateFrom, Optional<String> dateTo,Optional<String> exchange, 
				Optional<String> sort, Optional<Integer> limit, Optional<Integer> offset) 
	{
		return stockService.fetchCustomStockData(symbols, dateFrom, dateTo, exchange, sort, limit, offset);
	}
	
	
	
	
	
	
}
