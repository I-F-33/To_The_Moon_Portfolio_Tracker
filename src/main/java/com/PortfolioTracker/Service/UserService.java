package com.PortfolioTracker.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.PortfolioTracker.Domain.Authorities;
import com.PortfolioTracker.Domain.User;
import com.PortfolioTracker.Repository.AuthoritiesRepository;
import com.PortfolioTracker.Repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	AuthoritiesRepository authRepo;
	
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
		
		if(user.getUsername().equals("Administrator")) {
			Authorities authority2 = new Authorities();
			authority2.setAuthority("ROLE_ADMIN");
			authority2.setUser(user);
			authRepo.save(authority2);
		} 
		
		return user;
	}
	
	public User findById(User user) {
		return userRepo.findById(user.getId()).get();
	}
	
}
