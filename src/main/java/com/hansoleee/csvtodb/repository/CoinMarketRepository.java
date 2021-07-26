package com.hansoleee.csvtodb.repository;

import com.hansoleee.csvtodb.domain.CoinMarket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoinMarketRepository extends JpaRepository<CoinMarket, String>{
}
