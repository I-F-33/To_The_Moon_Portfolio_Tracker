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
import com.sun.jndi.toolkit.url.Uri;

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

	public ResponseEntity<StockEODDataResponse> fetchCustomStockData(String symbols, Optional<String> dateFrom, Optional<String> dateTo)
	{
		
		URI uri = UriComponentsBuilder.fromHttpUrl(baseUrl.concat("eod"))
									  .queryParam("access_key", key)
									  .queryParam("symbols", symbols)
									  .queryParamIfPresent("date_from", dateFrom)
									  .queryParamIfPresent("date_to", dateTo)
									  .build()
									  .toUri();
	  return restTemplate.getForEntity(uri, StockEODDataResponse.class);
	}
	
	public ResponseEntity<StockEODDataResponse> fetchLatestStockData(String symbols) 
	{
		URI uri = UriComponentsBuilder.fromHttpUrl(baseUrl.concat("/eod/latest"))
									  .queryParam("access_key", key)
									  .queryParam("symbols", symbols)
									  .build()
									  .toUri();
		return restTemplate.getForEntity(uri, StockEODDataResponse.class);
									  
	}
	
	public ResponseEntity<>
	
}

