package com.PortfolioTracker.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.PortfolioTracker.Domain.User;
import com.PortfolioTracker.Service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/login")
	public String login() {
		return "login.html";
	}
	
	@GetMapping("/signup")
	public String signUp(ModelMap model, UserDTO user) {
		model.
		return "signup.html";
	}
	
	@PostMapping("/signup")
	public String createUser (@PathVariable User user) {
		userService.saveUser(user);
		return"redirect:/login";
	}
}
