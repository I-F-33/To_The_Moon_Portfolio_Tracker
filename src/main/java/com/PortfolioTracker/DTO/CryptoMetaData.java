package com.PortfolioTracker.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CryptoMetaData {

	@JsonProperty("1. Information")
	private String information;
	
	@JsonProperty("2. Digital Currency Code")
	private String digitalCurrencyCode;
	
	@JsonProperty("3. Digital Currency Name")
	private String digitalCurrencyName;
	
	@JsonProperty("4. Market Code")
	private String marketCode;
	
	@JsonProperty("5. Market Name")
	private String marketName;
	
	@JsonProperty("6. Last Refreshed")
	private String lastRefreshed;
	
	@JsonProperty("7. Time Zone")
	private String timeZone;

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public String getDigitalCurrencyCode() {
		return digitalCurrencyCode;
	}

	public void setDigitalCurrencyCode(String digitalCurrencyCode) {
		this.digitalCurrencyCode = digitalCurrencyCode;
	}

	public String getDigitalCurrencyName() {
		return digitalCurrencyName;
	}

	public void setDigitalCurrencyName(String digitalCurrencyName) {
		this.digitalCurrencyName = digitalCurrencyName;
	}

	public String getMarketCode() {
		return marketCode;
	}

	public void setMarketCode(String marketCode) {
		this.marketCode = marketCode;
	}

	public String getMarketName() {
		return marketName;
	}

	public void setMarketName(String marketName) {
		this.marketName = marketName;
	}

	public String getLastRefreshed() {
		return lastRefreshed;
	}

	public void setLastRefreshed(String lastRefreshed) {
		this.lastRefreshed = lastRefreshed;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}
}
