package com.PortfolioTracker.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.PortfolioTracker.DTO.SignUpDTO;
import com.PortfolioTracker.Domain.User;
import com.PortfolioTracker.Service.UserService;

@Controller
public class RegistrationController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/signup")
	public String signUp(ModelMap model, SignUpDTO user) {
		model.put("user", user);
		return "signup.html";
		}
	
	@PostMapping("/signup")
	public String createUser (SignUpDTO user) {
		User userToBeSaved = userService.createUser(user);
		userService.saveUser(userToBeSaved);
		return"redirect:/login";
	}
}
