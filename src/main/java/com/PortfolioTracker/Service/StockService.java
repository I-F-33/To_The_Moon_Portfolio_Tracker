package com.PortfolioTracker.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PortfolioTracker.Domain.Stock;
import com.PortfolioTracker.Domain.User;
import com.PortfolioTracker.Repository.StockRepository;
import com.PortfolioTracker.Repository.UserRepository;

@Service
public class StockService {

	@Autowired
	private StockRepository stockRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	public Stock saveStockToUser(String symbol, Long userId) {
		//user saving stock to account
		User user = userRepo.findById(userId).get();
		
		//save stock data to stock object
		Stock stock= new Stock();
		stock.setSymbol(symbol);
		stock.setUser(user);
		
		//save stock to database
		stockRepo.save(stock);
		
		//add stock to user
		user.getStocks().add(stock);
		
		return stock;
	}
}
