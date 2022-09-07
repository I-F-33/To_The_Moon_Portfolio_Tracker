package com.PortfolioTracker.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.PortfolioTracker.DTO.StockListing;
import com.PortfolioTracker.Domain.Authorities;
import com.PortfolioTracker.Domain.Stock;
import com.PortfolioTracker.Domain.User;
import com.PortfolioTracker.Repository.AuthoritiesRepository;
import com.PortfolioTracker.Repository.CryptoRepository;
import com.PortfolioTracker.Repository.StockRepository;
import com.PortfolioTracker.Repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private AuthoritiesRepository authRepo;
	
	@Autowired
	private StockRepository stockRepo;
	
	@Autowired
	private CryptoRepository cryptoRepo;
	
	@Autowired
	private FileService fileservice;
	
	public User findByUserName(String username) {
		return userRepo.findByUsername(username);
	}
	
	public User createUser(User user) {
		Authorities authority = new Authorities();
		String encryptedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encryptedPassword);
		authority.setUser(user);
		authority.setAuthority("ROLE_USER");
		userRepo.save(user);
		authRepo.save(authority);
		
		return user;
	}
	
	public User findById(User user) {
		return userRepo.getById(user.getUser_id());
	}
	
	public User saveStockToUser(Long userId, StockListing stock) {
		User user = userRepo.findById(userId).get();
		Stock stockToBeSaved = new Stock();
		String stockSymbol = stock.getSymbol();
		stockToBeSaved.setSymbol(stockSymbol);
		stockToBeSaved.setUser(user);
		user.getStocks().add(stockToBeSaved);
		stockRepo.save(stockToBeSaved);
		
		return user;
	}
	
	//compares each saved user stock to the list of stock and extracts the matching stocklisting
	public List<StockListing> fetchAllUserStocks(Long userId) {
		List<Stock> userStocks = stockRepo.findAllStocksByUserId(userId);
		List<StockListing> stockList = fileservice.parseStockCsvFileToList();
		List<StockListing> matchingUserStocks = new ArrayList<>();
		
		for(Stock stock : userStocks) {
			Optional<StockListing> matchingStock = stockList.stream()
					 .filter(stockListing -> stockListing.getSymbol().equalsIgnoreCase(stock.getSymbol()))
					 .findFirst();
			
			matchingStock.ifPresentOrElse(match -> matchingUserStocks.add(match), () -> System.out.println("no match"));
		}
		return matchingUserStocks;
	}
	
	
	
}
