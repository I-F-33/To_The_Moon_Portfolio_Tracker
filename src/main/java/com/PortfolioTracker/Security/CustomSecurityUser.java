package com.PortfolioTracker.Security;

import org.springframework.security.core.userdetails.UserDetails;

import com.PortfolioTracker.Domain.User;

public class CustomSecurityUser extends User implements UserDetails{

	
	private static final long serialVersionUID = -9149156245112390905L;

	public CustomSecurityUser() {};
	
	public CustomSecurityUser(User user) {
		this.setAuthorities(user.getAuthorities());
		this.setUsername(user.getUsername());
		this.setPassword(user.getPassword());
		this.setId(user.getId());
		this.setInvestmentStrategy(user.getInvestmentStrategy());
	}
	@Override
	public String getUsername() {
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	

}
