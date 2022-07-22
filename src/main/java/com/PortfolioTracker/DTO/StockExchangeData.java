package com.PortfolioTracker.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StockExchangeData {

	@JsonProperty("name")
	private String name;
	
	@JsonProperty("acronym")
	private String acronym;
	
	@JsonProperty("mic")
	private String mic;

	@JsonProperty("country")
	private String country;

	@JsonProperty("country_code")
	private String country_code;

	@JsonProperty("city")
	private String city;
	
	@JsonProperty("website")
	private String website;
	
	@JsonProperty("timezone")
	private Timezone timezone;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAcronym() {
		return acronym;
	}

	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}

	public String getMic() {
		return mic;
	}

	public void setMic(String mic) {
		this.mic = mic;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountry_code() {
		return country_code;
	}

	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Timezone getTimezone() {
		return timezone;
	}

	public void setTimezone(Timezone timezone) {
		this.timezone = timezone;
	}
}
