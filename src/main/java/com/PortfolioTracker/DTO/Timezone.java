package com.PortfolioTracker.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Timezone {

	@JsonProperty("timezone")
	private String timezone;
	

	@JsonProperty("abbr")
	private String abbr;
	
	@JsonProperty("abbr_dst")
	private String abbr_dst;
	
	public String getTimezone() {
		return timezone;
	}
	
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}
	
	public String getAbbr() {
		return abbr;
	}
	
	public void setAbbr(String abbr) {
		this.abbr = abbr;
	}
	
	public String getAbbr_dst() {
		return abbr_dst;
	}
	
	public void setAbbr_dst(String abbr_dst) {
		this.abbr_dst = abbr_dst;
	}
}
