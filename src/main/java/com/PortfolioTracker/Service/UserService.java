package com.PortfolioTracker.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.PortfolioTracker.DTO.CryptoListing;
import com.PortfolioTracker.DTO.StockListing;
import com.PortfolioTracker.Domain.Authorities;
import com.PortfolioTracker.Domain.Crypto;
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
	
	public User findById(Long userId) {
		return userRepo.getById(userId);
	}
	
	public User saveStockToUser(Long userId, String stockName) {
		//finds matching stock from list of stocks to get stock data
		StockListing matchingStock = fileservice.fetchMatchingStocks(stockName).stream()
																			   .findFirst()
																			   .get();
		
		//finds user with matching id
		User user = userRepo.findById(userId).get();
		//creates new stock object with all the stock properties user wants saved
		Stock stockToBeSaved = new Stock();
		stockToBeSaved.setSymbol(matchingStock.getSymbol());
		stockToBeSaved.setName(matchingStock.getName());
		stockToBeSaved.setUser(user);
		stockToBeSaved.setSector(matchingStock.getSector());
		stockToBeSaved.setIndustry(matchingStock.getIndustry());
		user.getStocks().add(stockToBeSaved);
		System.out.println(stockToBeSaved.getSymbol());
		System.out.println(stockToBeSaved.getName());
		System.out.println(stockToBeSaved.getIndustry());
		System.out.println(stockToBeSaved.getSector());

		stockRepo.save(stockToBeSaved);
		
		return user;
	}
	
	public User saveCryptoToUser(Long userId, String cryptoName) {
		//find matching crypto from list of crypto
		CryptoListing matchingCrypto = fileservice.fetchMatchingCrypto(cryptoName).stream()
																				  .findFirst()
																			   	  .get();
		User user = userRepo.findById(userId).get();
		
		Crypto cryptoToBeSaved = new Crypto();
		//transfer cryptoDTO data to Crypto object
		cryptoToBeSaved.setName(matchingCrypto.getName());
		cryptoToBeSaved.setSymbol(matchingCrypto.getSymbol());
		cryptoToBeSaved.setUser(user);
		user.getCryptos().add(cryptoToBeSaved);
		
		cryptoRepo.save(cryptoToBeSaved);
		
		return user;
	}
	
	public List<Stock> fetchAllUserStocks(Long userId) {
		return stockRepo.findAllStocksByUserId(userId);
	}
	
	public List<Crypto> fetchAllUserCrypto(Long userId) {
		return cryptoRepo.fetchAllCryptoByUserId(userId);
	}
	
	
}
