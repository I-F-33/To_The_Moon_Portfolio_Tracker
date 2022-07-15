package com.PortfolioTracker.Web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LandingPageController {

	@GetMapping("/landingpage")
	public String displayLandingPage(ModelMap model) {
		return "landing_page.html";
	}
	
	
}
