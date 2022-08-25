package com.PortfolioTracker.DTO;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DailyCryptoResponse {

	@JsonProperty("Meta Data")
	private CryptoMetaData metaData;
	
	@JsonProperty("Time Series (Digital Currency Daily)")
	private Map<String, DailyCryptoData> dailyCryptoData;

	public CryptoMetaData getMetaData() {
		return metaData;
	}

	public void setMetaData(CryptoMetaData metaData) {
		this.metaData = metaData;
	}

	public Map<String, DailyCryptoData> getDailyCryptoData() {
		return dailyCryptoData;
	}

	public void setDailyStockData(Map<String, DailyCryptoData> dailyCryptoData) {
		this.dailyCryptoData = dailyCryptoData;
	}
}
