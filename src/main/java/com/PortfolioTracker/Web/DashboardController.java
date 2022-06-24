package com.PortfolioTracker.Web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DashboardController {

	@PostMapping("/logout")
	public void logout() {
		
	}
}
