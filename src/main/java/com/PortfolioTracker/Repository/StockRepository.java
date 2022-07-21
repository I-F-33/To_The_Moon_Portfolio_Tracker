package com.PortfolioTracker.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.PortfolioTracker.Domain.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

}
