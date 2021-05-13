package com.dsumtsov.microservices.currencyconversionservice.controller;

import com.dsumtsov.microservices.currencyconversionservice.dto.CurrencyConversionDTO;
import com.dsumtsov.microservices.currencyconversionservice.dto.CurrencyExchangeDTO;
import com.dsumtsov.microservices.currencyconversionservice.feign.CurrencyExchangeServiceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/currency-conversion")
@RequiredArgsConstructor
public class CurrencyConversionController {

    private final CurrencyExchangeServiceClient client;

    @GetMapping("/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionDTO convertCurrency(@PathVariable String from,
                                                 @PathVariable String to,
                                                 @PathVariable BigDecimal quantity) {

        CurrencyExchangeDTO response = client.retrieveExchangeValue(from, to);
        return new CurrencyConversionDTO(
                response.getId(),
                from, to, quantity,
                response.getConversionMultiple(),
                quantity.multiply(response.getConversionMultiple()),
                response.getEnvironment()
        );
    }
}
