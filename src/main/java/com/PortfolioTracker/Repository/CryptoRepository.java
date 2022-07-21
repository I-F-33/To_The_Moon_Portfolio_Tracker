package com.PortfolioTracker.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.PortfolioTracker.Domain.Crypto;

@Repository
public interface CryptoRepository extends JpaRepository<Crypto, Long>{

}
