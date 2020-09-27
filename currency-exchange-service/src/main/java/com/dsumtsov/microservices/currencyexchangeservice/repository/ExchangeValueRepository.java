package com.dsumtsov.microservices.currencyexchangeservice.repository;

import com.dsumtsov.microservices.currencyexchangeservice.domain.ExchangeValue;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {
    Optional<ExchangeValue> findByFromAndTo(@NonNull String from, @NonNull String to);
}
