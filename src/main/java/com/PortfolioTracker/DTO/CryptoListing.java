package com.PortfolioTracker.DTO;

public class CryptoListing implements Comparable<CryptoListing>{

	private String symbol;
	private String name;
	
	public CryptoListing() {};
	
	public CryptoListing(String symbol, String name) {
		this.symbol = symbol;
		this.name = name;
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

	@Override
	public int compareTo(CryptoListing o) {
		return this.name.compareTo(o.name);
	}
}
