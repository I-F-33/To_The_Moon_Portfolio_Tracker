package com.PortfolioTracker.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.PortfolioTracker.DTO.SignUpDTO;
import com.PortfolioTracker.Domain.User;
import com.PortfolioTracker.Service.AuthoritiesService;
import com.PortfolioTracker.Service.UserService;

@Controller
public class RegistrationController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthoritiesService authService;
	
	@GetMapping("/signup")
	public String signUp(ModelMap model, SignUpDTO user) {
		model.put("user", user);
		return "signup.html";
		}
	
	@PostMapping("/signup")
	public String createUser (SignUpDTO user) {
		User userToBeSaved = userService.createUser(user);
		User savedUser = userService.saveUser(userToBeSaved);
		if(savedUser.getUserName().equals("Administrator")) {
			authService.grantAuthority(savedUser, "ADMIN");
		}else {
			authService.grantAuthority(savedUser, "USER");
		}
		return"redirect:/login";
	}
}
