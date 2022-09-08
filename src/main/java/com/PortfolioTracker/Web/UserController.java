package com.PortfolioTracker.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
	
	@PostMapping("/{userId}/{cryptoName}/saveCrypto")
	public String saveCryptoToUser(@PathVariable String cryptoName ,@PathVariable Long userId) {
		userService.saveCryptoToUser(userId, cryptoName);
		return "redirect:/dashboard";
	}
	
}
