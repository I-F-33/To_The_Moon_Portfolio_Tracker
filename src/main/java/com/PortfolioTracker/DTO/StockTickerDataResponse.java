package com.PortfolioTracker.DTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StockTickerDataResponse {

	@JsonProperty("pagination")
	private PaginationInfo pagination;

	@JsonProperty("data")
	private List<StockTickerData> data;
	
	public PaginationInfo getPagination() {
		return pagination;
	}
	
	public void setPagination(PaginationInfo pagination) {
		this.pagination = pagination;
	}
	
	public List<StockTickerData> getData() {
		return data;
	}
	
	public void setData(List<StockTickerData> data) {
		this.data = data;
	}
}
