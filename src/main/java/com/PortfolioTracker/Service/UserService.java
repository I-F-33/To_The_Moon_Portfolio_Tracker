package com.PortfolioTracker.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PortfolioTracker.DTO.SignUpDTO;
import com.PortfolioTracker.Domain.User;
import com.PortfolioTracker.Repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	public User saveUser(User user) {
		return userRepo.save(user);
	}
	
	public User findByUserName(String username) {
		return userRepo.findByUsername(username);
	}
	
	public User createUser(SignUpDTO user) {
		User userToBeCreated = new User(user);
		return userToBeCreated;
	}
	
}
