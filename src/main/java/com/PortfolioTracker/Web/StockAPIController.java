package com.PortfolioTracker.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class StockAPIController {

	
	@Autowired
	private RestTemplate restTemplate;
	@Value("${stock.base.url}")
	private String baseUrl;
	@Value("${stock.api.key}")
	private String key;
	
	
	
	
}
