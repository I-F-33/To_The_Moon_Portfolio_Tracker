package com.PortfolioTracker.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.PortfolioTracker.DTO.CryptoListing;
import com.PortfolioTracker.DTO.StockListing;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

@Service
public class FileService {

	
	public List<StockListing> parseStockCsvFileToList() {
		File file = new File("stock_list.csv");
		
		try {
			CSVReader reader = new CSVReader(new FileReader(file));
			reader.skip(1);
			
			String[] nextStock;
			List<StockListing> stocks = new ArrayList<>();
			
			while((nextStock = reader.readNext()) != null) {
				stocks.add(new StockListing(nextStock[0], nextStock[1], nextStock[2], nextStock[3]));
			}
			return stocks;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (CsvValidationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		
}
	public List<CryptoListing> parseCryptoCsvFileToList() {
		File file = new File("digital_currency_list.csv");
		
		try {
			CSVReader reader = new CSVReader(new FileReader(file));
			reader.skip(1);
			
			String[] nextCrypto;
			List<CryptoListing> crypto = new ArrayList<>();
			
			while((nextCrypto = reader.readNext()) != null) {
				crypto.add(new CryptoListing(nextCrypto[0], nextCrypto[1]));
			}
			return crypto;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (CsvValidationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		
}
	
}
