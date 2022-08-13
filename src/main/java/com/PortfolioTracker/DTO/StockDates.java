package com.PortfolioTracker.DTO;

public class StockDates {

	private String date;
	
	//@JsonProperty("1. open")
	private Double open;
	
	//@JsonProperty("2. close")
	private Double high;
	
	//@JsonProperty("3. low")
	private Double low;
	
	//@JsonProperty("4. close")
	private Double close;
	
	//@JsonProperty("5. volume")
	private Integer volume;

	public StockDates(String date, Double open, Double high, Double low, Double close, Integer volume) {
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
		this.volume = volume;
	}

	public StockDates() {};
	
	public Double getOpen() {
		return open;
	}

	public void setOpen(Double open) {
		this.open = open;
	}

	public Double getHigh() {
		return high;
	}

	public void setHigh(Double high) {
		this.high = high;
	}

	public Double getLow() {
		return low;
	}

	public void setLow(Double low) {
		this.low = low;
	}

	public Double getClose() {
		return close;
	}

	public void setClose(Double close) {
		this.close = close;
	}

	public Integer getVolume() {
		return volume;
	}

	public void setVolume(Integer volume) {
		this.volume = volume;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
