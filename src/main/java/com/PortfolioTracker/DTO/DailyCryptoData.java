package com.PortfolioTracker.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DailyCryptoData {

	@JsonProperty("1a. open (USD)")
	private String open;
	
	@JsonProperty("1b. open (USD)")
	private String open2;
	
	@JsonProperty("2a. high (USD)")
	private String high;
	
	@JsonProperty("2b. high (USD)")
	private String high2;
	
	@JsonProperty("3a. low (USD)")
	private String low;
	
	@JsonProperty("3b. low (USD)")
	private String low2;
	
	@JsonProperty("4a. close (USD)")
	private String close;
	
	@JsonProperty("4b. close (USD)")
	private String close2;
	
	@JsonProperty("5. volume")
	private String volume;
	
	@JsonProperty("6. market cap (USD)")
	private String marketCap;

	public String getOpen() {
		return open;
	}

	public void setOpen(String open) {
		this.open = open;
	}

	public String getOpen2() {
		return open2;
	}

	public void setOpen2(String open2) {
		this.open2 = open2;
	}

	public String getHigh() {
		return high;
	}

	public void setHigh(String high) {
		this.high = high;
	}

	public String getHigh2() {
		return high2;
	}

	public void setHigh2(String high2) {
		this.high2 = high2;
	}

	public String getLow() {
		return low;
	}

	public void setLow(String low) {
		this.low = low;
	}

	public String getLow2() {
		return low2;
	}

	public void setLow2(String low2) {
		this.low2 = low2;
	}

	public String getClose() {
		return close;
	}

	public void setClose(String close) {
		this.close = close;
	}

	public String getClose2() {
		return close2;
	}

	public void setClose2(String close2) {
		this.close2 = close2;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getMarketCap() {
		return marketCap;
	}

	public void setMarketCap(String marketCap) {
		this.marketCap = marketCap;
	}
}
