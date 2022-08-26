package com.PortfolioTracker.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.PortfolioTracker.Domain.User;
import com.PortfolioTracker.Service.UserService;

@Controller
public class RegistrationController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/signup")
	public String signUp(ModelMap model) {
		model.put("user", new User());
		return "signup.html";
		}
	
	@PostMapping("/signup")
	public String createUser (User user) {
		userService.createUser(user);
		return"redirect:/login";
	}
}
