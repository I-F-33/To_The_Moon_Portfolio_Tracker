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
	@Value("${asset.base.url}")
	private String baseUrl;
	@Value("${asset.api.key}")
	private String key;
	
	

	
}

