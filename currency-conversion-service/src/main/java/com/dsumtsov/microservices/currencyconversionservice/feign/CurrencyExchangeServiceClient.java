package com.dsumtsov.microservices.currencyconversionservice.feign;

import com.dsumtsov.microservices.currencyconversionservice.dto.CurrencyExchangeDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="currency-exchange-service")
public interface CurrencyExchangeServiceClient {
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    CurrencyExchangeDTO retrieveExchangeValue(@PathVariable("from") String from,
                                              @PathVariable("to") String to);
}
