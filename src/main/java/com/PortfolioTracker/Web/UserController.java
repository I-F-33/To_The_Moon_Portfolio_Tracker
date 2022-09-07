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

	@PostMapping("/{userId}/saveStock")
	public String saveStockToUser(StockListing stock,@PathVariable Long userId) {
		userService.saveStockToUser(userId, stock);
		return "redirect:/dashboard";
	}
}
