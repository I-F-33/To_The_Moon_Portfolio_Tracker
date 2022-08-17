package com.PortfolioTracker.Service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.PortfolioTracker.DTO.DailyStockResponse;
import com.PortfolioTracker.DTO.SearchEndpointResponse;

@Service
public class StockAPIService {

	@Autowired
	private RestTemplate restTemplate;
	@Value("${asset.base.url}")
	private String baseUrl;
	@Value("${asset.api.key}")
	private String key;
	
	public ResponseEntity<DailyStockResponse> fetchDailyStockData(String symbol) {
		
		URI uri = UriComponentsBuilder.fromHttpUrl(baseUrl)
				                      .queryParam("function", "TIME_SERIES_DAILY")
   									  .queryParam("symbol", symbol)
   									  .queryParam("outputsize", "full")
   									  .queryParam("datatype", "json")
									  .queryParam("apikey", key)
									  .build()
									  .toUri();
		
		ResponseEntity<DailyStockResponse> response = restTemplate.getForEntity(uri, DailyStockResponse.class);
		
		return response;
									  
	}
	
	public ResponseEntity<SearchEndpointResponse> fetchBestReponseForKeyword(String keywords){
		URI uri = UriComponentsBuilder.fromHttpUrl(baseUrl)
									  .queryParam("function", "SYMBOL_SEARCH")
									  .queryParam("keywords", keywords)
									  .queryParam("datatype", "json")
									  .queryParam("apikey", key)
									  .build()
									  .toUri();
		
		ResponseEntity<SearchEndpointResponse> response = restTemplate.getForEntity(uri, SearchEndpointResponse.class);
		
		System.out.println(response.getBody().toString());
		return response;
		
	}

	
}

