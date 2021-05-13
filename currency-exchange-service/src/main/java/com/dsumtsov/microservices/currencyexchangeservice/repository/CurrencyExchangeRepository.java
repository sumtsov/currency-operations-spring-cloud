package com.dsumtsov.microservices.currencyexchangeservice.repository;

import com.dsumtsov.microservices.currencyexchangeservice.entity.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;
import lombok.NonNull;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {
    Optional<CurrencyExchange> findByFromAndTo(@NonNull String from, @NonNull String to);
}
