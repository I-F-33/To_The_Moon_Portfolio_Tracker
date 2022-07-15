package com.PortfolioTracker.DTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StockEODDataPoint {

	@JsonProperty("pagination")
	private PaginationInfo pagination;
	@JsonProperty("data")
	private List<StockEODData> data;
	
	public PaginationInfo getPagination() {
		return pagination;
	}
	public void setPagination(PaginationInfo pagination) {
		this.pagination = pagination;
	}
	public List<StockEODData> getData() {
		return data;
	}
	public void setData(List<StockEODData> data) {
		this.data = data;
	}
	
}
