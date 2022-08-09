package com.PortfolioTracker.DTO;

import java.util.Date;
import java.util.List;

import org.thymeleaf.expression.Dates;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = TimeSeriesDeserializer.class)
public class TimeSeries {

	private List<Day> days;

	public List<Day> getDays() {
		return days;
	}

	public void setDays(List<Day> days) {
		this.days = days;
	}
	
}
