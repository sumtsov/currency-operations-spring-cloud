package com.dsumtsov.microservices.currencyexchangeservice.controller;

import com.dsumtsov.microservices.currencyexchangeservice.domain.ExchangeValue;
import com.dsumtsov.microservices.currencyexchangeservice.repository.ExchangeValueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/currency-exchange")
@RequiredArgsConstructor
public class CurrencyExchangeController {

    private final ExchangeValueRepository repository;

    @GetMapping("/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
        return repository.findByFromAndTo(from, to)
                .orElseThrow(() -> new RuntimeException("No exchange value found")); // TODO: add ExcepionsController
    }
}
