package com.PortfolioTracker.Web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

	@GetMapping("/landingpage")
	public String displayDashboard(ModelMap model) {
		return "dashboard.html";
	}
	
}
