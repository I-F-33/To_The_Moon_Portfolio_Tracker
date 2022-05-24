package com.PortfolioTracker.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.PortfolioTracker.Domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query(value = "select u from User u " +
			       "left join fetch authorities.u " +
			       "where u.username = :username", 
			       nativeQuery = true)
	public User findByUsername(String username);

}
