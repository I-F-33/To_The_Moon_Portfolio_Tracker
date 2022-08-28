package com.PortfolioTracker.DTO;

public class Search {

	private String searchString;
	private String searchType;
	
	public String getSearchString() {
		return searchString;
	}
	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	@Override
	public String toString() {
		return "Search [searchString=" + searchString + ", searchType=" + searchType + "]";
	}
	
	
}
