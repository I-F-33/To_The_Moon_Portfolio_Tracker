package com.PortfolioTracker.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.PortfolioTracker.Domain.Crypto;

@Repository
public interface CryptoRepository extends JpaRepository<Crypto, Long>{

	@Query(value="SELECT * FROM crypto c WHERE c.user_id = :userId", nativeQuery = true)
	public List<Crypto> fetchAllCryptoByUserId(@Param("userId")Long userId);
	
}
