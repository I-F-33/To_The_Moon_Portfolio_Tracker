package com.PortfolioTracker.Web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.PortfolioTracker.Security.CustomSecurityUser;

@Controller
public class DashboardController {

		
	@GetMapping("/dashboard")
	public String displayDashboard(@AuthenticationPrincipal CustomSecurityUser user, ModelMap model) {
		model.put("user", user);
		return "dashboard.html";
	}
	
	//@GetMapping("/{userId}")
	
	
}
