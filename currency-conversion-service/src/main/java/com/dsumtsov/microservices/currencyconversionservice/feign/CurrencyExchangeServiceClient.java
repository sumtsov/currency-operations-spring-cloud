package com.dsumtsov.microservices.currencyconversionservice.feign;

import com.dsumtsov.microservices.currencyconversionservice.dto.CurrencyConversionDTO;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="netflix-zuul-api-gateway-server")
@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeServiceClient {
    @GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
    CurrencyConversionDTO retrieveExchangeValue(@PathVariable("from") String from,
                                                @PathVariable("to") String to);
}
