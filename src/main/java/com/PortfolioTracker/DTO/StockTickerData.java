package com.PortfolioTracker.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StockTickerData {

	@JsonProperty("name")
	private String name;
	
	@JsonProperty("symbol")
	private String symbol;
	
	@JsonProperty("stock_exchange")
	private StockExchangeData stock_exchange;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public StockExchangeData getStock_exchange() {
		return stock_exchange;
	}
	public void setStock_exchange(StockExchangeData stock_exchange) {
		this.stock_exchange = stock_exchange;
	}

}
