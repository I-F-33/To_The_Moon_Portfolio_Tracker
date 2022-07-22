package com.PortfolioTracker.Service;

import java.net.URI;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.PortfolioTracker.DTO.StockEODDataResponse;
import com.PortfolioTracker.DTO.StockTickerDataResponse;

@Service
public class StockAPIService {

	@Autowired
	private RestTemplate restTemplate;
	@Value("${stock.base.url}")
	private String baseUrl;
	@Value("${stock.api.key}")
	private String key;
	
	public LocalDate stringToLocalDate(Optional<String> date) 
	{
		if (date.isPresent()) {
			return LocalDate.parse(date.get(), DateTimeFormatter.ISO_DATE);
		} else {
			return null;
		}
	}

	//fetches data with the user input parameters
	public ResponseEntity<StockEODDataResponse> fetchCustomStockData
	(String symbols, Optional<String> dateFrom, Optional<String> dateTo, Optional<String> exchange, 
			Optional<String> sort, Optional<Integer> limit, Optional<Integer> offset)
	{
		
		URI uri = UriComponentsBuilder.fromHttpUrl(baseUrl.concat("eod"))
									  .queryParam("access_key", key)
									  .queryParam("symbols", symbols)
									  .queryParamIfPresent("exchange", exchange)
									  .queryParamIfPresent("sort", sort)
									  .queryParamIfPresent("limit", limit)
									  .queryParamIfPresent("date_from", dateFrom)
									  .queryParamIfPresent("date_to", dateTo)
									  .queryParamIfPresent("offset", offset)
									  .build()
									  .toUri();
		
		ResponseEntity<StockEODDataResponse> response = restTemplate.getForEntity(uri, StockEODDataResponse.class);
		System.out.println(response.getBody().toString());
		
	  return restTemplate.getForEntity(uri, StockEODDataResponse.class);
	}
	
	//fetches stock data for selected symbol, predetermined parameters
	public ResponseEntity<StockEODDataResponse> fetchLatestStockData(String symbols) 
	{
		URI uri = UriComponentsBuilder.fromHttpUrl(baseUrl.concat("/eod/latest"))
									  .queryParam("access_key", key)
									  .queryParam("symbols", symbols)
									  .build()
									  .toUri();
		return restTemplate.getForEntity(uri, StockEODDataResponse.class);
									  
	}
	
	
	//fetch stock ticker symbol, primarily for search bar data
	public ResponseEntity<StockTickerDataResponse> fetchStockTickerData() 
	{
		URI uri = UriComponentsBuilder.fromHttpUrl(baseUrl.concat("/tickers"))
				.queryParam("access_key", key)
				.build()
				.toUri();
		
		return restTemplate.getForEntity(uri, StockTickerDataResponse.class);
	}
	
}

