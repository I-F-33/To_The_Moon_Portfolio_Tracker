package com.PortfolioTracker.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.PortfolioTracker.Domain.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

	@Query(value="SELECT * FROM stock s WHERE s.user_id = :userId", nativeQuery = true)
	List<Stock> findAllStocksByUserId(@Param("userId")Long userId);
}
