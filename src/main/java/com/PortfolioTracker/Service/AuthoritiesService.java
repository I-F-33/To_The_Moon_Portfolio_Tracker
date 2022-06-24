package com.PortfolioTracker.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PortfolioTracker.Domain.Authorities;
import com.PortfolioTracker.Domain.User;
import com.PortfolioTracker.Repository.AuthoritiesRepository;

@Service
public class AuthoritiesService {

	@Autowired
	UserService userService;
	
	@Autowired
	AuthoritiesRepository authRepo;
	
	public void grantAuthority(User user, String authority) {
		User queriedUser = userService.findById(user);
		
		if (authority.equals("ADMIN")) {
		Authorities auth1 = new Authorities("ADMIN", queriedUser);
		Authorities auth2 = new Authorities("USER", queriedUser);
		authRepo.save(auth1);
		authRepo.save(auth2);
		} else if (authority.equals("USER")) {
			Authorities auth1 = new Authorities("USER", queriedUser);
			authRepo.save(auth1);
		}
	}
}
