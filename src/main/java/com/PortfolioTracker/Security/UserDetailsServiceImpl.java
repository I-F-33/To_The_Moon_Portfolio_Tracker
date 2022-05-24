package com.PortfolioTracker.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.PortfolioTracker.Domain.User;
import com.PortfolioTracker.Service.UserService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.findByUserName(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("Username and/or Passowrd was not found. Please try again.");
		}
		
		return new CustomSecurityUser(user);
	}

}
