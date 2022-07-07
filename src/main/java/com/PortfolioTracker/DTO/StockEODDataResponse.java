package com.PortfolioTracker.DTO;

public class StockEODDataResponse {

	private PaginationInfo pagination;
	private StockEODData data;
	
	public PaginationInfo getPagination() {
		return pagination;
	}
	public void setPagination(PaginationInfo pagination) {
		this.pagination = pagination;
	}
	public StockEODData getData() {
		return data;
	}
	public void setData(StockEODData data) {
		this.data = data;
	}
	
}
