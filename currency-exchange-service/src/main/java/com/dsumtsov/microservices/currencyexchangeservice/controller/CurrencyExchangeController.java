package com.dsumtsov.microservices.currencyexchangeservice.controller;

import com.dsumtsov.microservices.currencyexchangeservice.entity.CurrencyExchange;
import com.dsumtsov.microservices.currencyexchangeservice.repository.CurrencyExchangeRepository;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RestController
@RequestMapping("/currency-exchange")
@RequiredArgsConstructor
public class CurrencyExchangeController {

    private final CurrencyExchangeRepository repository;
    private final Environment environment;


    @GetMapping("/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(@PathVariable String from,
                                                  @PathVariable String to) {

        log.info("retrieveExchangeValue params -> from: {}, to: {}", from, to);

        CurrencyExchange exchangeValue = repository.findByFromAndTo(from, to)
                .orElseThrow(() -> new RuntimeException("No exchange value found")); // TODO: add ExceptionsController
        String port = environment.getProperty("local.server.port");
        exchangeValue.setEnvironment(port);

        return exchangeValue;
    }
}
