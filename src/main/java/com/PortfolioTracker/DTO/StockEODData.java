package com.PortfolioTracker.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StockEODData {

	@JsonProperty("open")
	private Double open;
	@JsonProperty("high")
	private Double high;
	@JsonProperty("low")
	private Double low;
	@JsonProperty("close")
	private Double close;
	@JsonProperty("volume")
	private Double volume;
	@JsonProperty("adj_high")
	private Double adj_high;
	@JsonProperty("adj_low")
	private Double adj_low;
	@JsonProperty("adj_close")
	private Double adj_close;
	@JsonProperty("adj_open")
	private Double adj_open;
	@JsonProperty("adj_volume")
	private Double adj_volume;
	@JsonProperty("split_factor")
	private Double split_factor;
	@JsonProperty("dividend")
	private Double dividend;
	@JsonProperty("symbol")
	private String symbol;
	@JsonProperty("exchange")
	private String exchange;
	@JsonProperty("date")
	private String date;
	
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
	public Double getVolume() {
		return volume;
	}
	public void setVolume(Double volume) {
		this.volume = volume;
	}
	public Double getAdj_high() {
		return adj_high;
	}
	public void setAdj_high(Double adj_high) {
		this.adj_high = adj_high;
	}
	public Double getAdj_low() {
		return adj_low;
	}
	public void setAdj_low(Double adj_low) {
		this.adj_low = adj_low;
	}
	public Double getAdj_close() {
		return adj_close;
	}
	public void setAdj_close(Double adj_close) {
		this.adj_close = adj_close;
	}
	public Double getAdj_open() {
		return adj_open;
	}
	public void setAdj_open(Double adj_open) {
		this.adj_open = adj_open;
	}
	public Double getAdj_volume() {
		return adj_volume;
	}
	public void setAdj_volume(Double adj_volume) {
		this.adj_volume = adj_volume;
	}
	public Double getSplit_factor() {
		return split_factor;
	}
	public void setSplit_factor(Double split_factor) {
		this.split_factor = split_factor;
	}
	public Double getDividend() {
		return dividend;
	}
	public void setDividend(Double dividend) {
		this.dividend = dividend;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getExchange() {
		return exchange;
	}
	public void setExchange(String exchange) {
		this.exchange = exchange;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
