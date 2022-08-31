package com.PortfolioTracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.PortfolioTracker"})
@SpringBootApplication
public class ToTheMoonPortfolioTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToTheMoonPortfolioTrackerApplication.class, args);
	}

}
