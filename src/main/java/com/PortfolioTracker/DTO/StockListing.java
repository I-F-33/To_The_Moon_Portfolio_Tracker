package com.PortfolioTracker.DTO;

public class StockListing implements Comparable<StockListing> {

	String symbol;
	String name;
	String sector;
	String industry;
	
	public StockListing() {};
	
	public StockListing(String symbol, String name, String sector, String industry) {
		this.symbol = symbol;
		this.name = name;
		this.sector = sector;
		this.industry = industry;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	@Override
	public String toString() {
		return "StockListing [symbol=" + symbol + ", name=" + name + ", sector=" + sector + ", Industry=" + industry
				+ "]";
	}

	@Override
	public int compareTo(StockListing o) {
		return this.name.compareTo(o.name);
	}
	
}
