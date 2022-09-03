package com.PortfolioTracker.Web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.PortfolioTracker.DTO.CryptoListing;
import com.PortfolioTracker.DTO.Search;
import com.PortfolioTracker.DTO.StockListing;
import com.PortfolioTracker.Domain.User;
import com.PortfolioTracker.Service.FileService;

@Controller
public class ChartController {

	@Autowired
	FileService fileService;
	
	
}
