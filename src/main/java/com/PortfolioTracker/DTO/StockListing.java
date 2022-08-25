package com.PortfolioTracker.DTO;

public class StockListing {

	String stockSymbol;
	String stockName;
	String stockSector;
	String stockIndustry;
	
	public StockListing() {};
	
	public StockListing(String symbol, String name, String sector, String industry) {
		this.stockSymbol = symbol;
		this.stockName = name;
		this.stockSector = sector;
		this.stockIndustry = industry;
	}

	public String getSymbol() {
		return stockSymbol;
	}

	public void setSymbol(String symbol) {
		this.stockSymbol = symbol;
	}

	public String getName() {
		return stockName;
	}

	public void setName(String name) {
		this.stockName = name;
	}

	public String getSector() {
		return stockSector;
	}

	public void setSector(String sector) {
		this.stockSector = sector;
	}

	public String getIndustry() {
		return stockIndustry;
	}

	public void setIndustry(String industry) {
		stockIndustry = industry;
	}

	@Override
	public String toString() {
		return "StockListing [symbol=" + stockSymbol + ", name=" + stockName + ", sector=" + stockSector + ", Industry=" + stockIndustry
				+ "]";
	}
	
}
