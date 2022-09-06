package com.PortfolioTracker.Service;

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
	AuthoritiesRepository authRepo;
	
	@Autowired
	StockRepository stockRepo;
	
	@Autowired
	CryptoRepository cryptoRepo;
	
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
		return userRepo.getById(user.getId());
	}
	
	public User saveStockToUser(User user, StockListing stock) {
		Stock stockToBeSaved = new Stock();
		String stockSymbol = stock.getSymbol();
		stockToBeSaved.setSymbol(stockSymbol);
		stockToBeSaved.setUser(user);
		user.getStocks().add(stockToBeSaved);
		
		stockRepo.save(stockToBeSaved);
		
		return user;
	}
}
