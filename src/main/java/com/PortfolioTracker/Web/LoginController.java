package com.PortfolioTracker.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.PortfolioTracker.Service.UserService;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String login() {
		return "login.html";
	}	
	
	@GetMapping("")
	public String directToLoginPage() {
		return "redirect:/login.html";
	}
}
