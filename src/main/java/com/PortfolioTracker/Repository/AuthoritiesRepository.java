package com.PortfolioTracker.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.PortfolioTracker.Domain.Authorities;

@Repository
public interface AuthoritiesRepository extends JpaRepository<Authorities, Long> {

}
