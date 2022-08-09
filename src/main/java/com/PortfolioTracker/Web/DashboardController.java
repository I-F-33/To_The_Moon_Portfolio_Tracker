package com.PortfolioTracker.Web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

	@GetMapping("/dashboard")
	public String displayLandingPage(ModelMap model) {
		return "dashboard.html";
	}
	
	
	
	
}
