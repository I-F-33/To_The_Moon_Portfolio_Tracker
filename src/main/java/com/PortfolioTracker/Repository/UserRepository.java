package com.PortfolioTracker.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.PortfolioTracker.Domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	void findByUsername(String username);

}
