package com.PortfolioTracker.Domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
	
	private Long user_id;
	private String username;
	private String password;
	private Set<Authorities> authorities;
	private Set<Stock> stocks;
	private Set<Crypto> cryptos;

	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return user_id;
	}
	public void setId(Long id) {
		this.user_id = id;
	}
	@Column(nullable = false, unique = true)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="user")
	public Set<Authorities> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(Set<Authorities> authorities) {
		this.authorities = authorities;
	}
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="user")
	public Set<Stock> getStocks() {
		return stocks;
	}
	public void setStocks(Set<Stock> stocks) {
		this.stocks = stocks;
	}
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="user")
	public Set<Crypto> getCryptos() {
		return cryptos;
	}
	

	public void setCryptos(Set<Crypto> cryptos) {
		this.cryptos = cryptos;
	}
	

	
}
