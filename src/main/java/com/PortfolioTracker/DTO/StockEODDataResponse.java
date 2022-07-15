package com.PortfolioTracker.DTO;

import java.util.List;

public class StockEODDataResponse {

	private List<StockEODDataPoint> response;

	public List<StockEODDataPoint> getResponse() {
		return response;
	}

	public void setResponse(List<StockEODDataPoint> response) {
		this.response = response;
	}
}
