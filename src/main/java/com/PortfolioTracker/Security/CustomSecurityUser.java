package com.PortfolioTracker.Security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.PortfolioTracker.Domain.User;

public class CustomSecurityUser extends User implements UserDetails{

	
	private static final long serialVersionUID = -9149156245112390905L;

	public CustomSecurityUser() {};
	
	public CustomSecurityUser(User user) {
		this.setAuthorities(user.getAuthorities());
		this.setUserName(user.getUserName());
		this.setPassword(user.getPassword());
		this.setId(user.getId());
	}
	@Override
	public String getUsername() {
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return false;
	}

	

}
