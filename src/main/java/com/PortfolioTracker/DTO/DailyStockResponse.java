package com.PortfolioTracker.DTO;

import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DailyStockResponse {

	@JsonProperty("Meta Data")
	private MetaData metaData;
	

	@JsonProperty("Time Series (Daily)")
	private Map<String, DailyStockData> dailyStockData = new LinkedHashMap<String, DailyStockData>();


	public MetaData getMetaData() {
		return metaData;
	}


	public void setMetaData(MetaData metaData) {
		this.metaData = metaData;
	}


	public Map<String, DailyStockData> getDailyStockData() {
		return dailyStockData;
	}


	public void setDailyStockData(Map<String, DailyStockData> dailyStockData) {
		this.dailyStockData = dailyStockData;
	}
	
	
}
