package com.PortfolioTracker.DTO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class TimeSeriesDeserializer extends StdDeserializer<TimeSeries> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected TimeSeriesDeserializer(Class<?> vc) {
		super(vc);
	
	}
	@Override
	public TimeSeries deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
		
		List<Day> days = new ArrayList<>();
		JsonNode node = p.getCodec().readTree(p);
		Iterator<Entry<String, JsonNode>> data = node.fields();
		//Iterate and seperate Json data and map to DTO
		data.forEachRemaining(dataToBeParsed -> {
			//map  data to DTO
			String date = dataToBeParsed.getKey();
			JsonNode dataValues = dataToBeParsed.getValue();
			Double open = dataValues.get("1. open").asDouble();
			Double high = dataValues.get("2. high").asDouble();
			Double low = dataValues.get("3. low").asDouble();
			Double close = dataValues.get("4. close").asDouble();
			Integer volume = dataValues.get("5, volume").asInt();
			
			Day day = new Day(date, open, high, low, close, volume);
			
			days.add(day);	
		});
		
		//map data to time series object
		TimeSeries dataForDays = new TimeSeries();
		dataForDays.setDays(days);
		return dataForDays;
	}

}
