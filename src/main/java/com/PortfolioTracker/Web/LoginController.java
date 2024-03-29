package com.PortfolioTracker.Web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
	
	@GetMapping("/logout")
	public String logout() {
		
		return "redirect:/login.html";
	}
}
