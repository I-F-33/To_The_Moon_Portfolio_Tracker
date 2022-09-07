package com.PortfolioTracker.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.PortfolioTracker.DTO.StockListing;
import com.PortfolioTracker.Service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;

	@PostMapping("/{userId}/{stockName}/saveStock")
	public String saveStockToUser(@PathVariable String stockName ,@PathVariable Long userId) {
		userService.saveStockToUser(userId, stockName);
		return "redirect:/dashboard";
	}
	
	
}
