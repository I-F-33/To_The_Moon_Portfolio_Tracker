package com.PortfolioTracker.DTO;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;


public class TimeSeries {
	
	private Map<String, Object> dynamicDates = new HashMap<>();
    
	@JsonAnyGetter
    @JsonAnySetter
    public void setUnknownFields(String name, Object value) {
        dynamicDates.put(name, value);
    }
    
    public Map<String, Object> getFieldsMap() {
        return dynamicDates;
    }

}

	


	

