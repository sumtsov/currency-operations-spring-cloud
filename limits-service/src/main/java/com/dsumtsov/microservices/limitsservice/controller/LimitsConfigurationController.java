package com.dsumtsov.microservices.limitsservice.controller;

import com.dsumtsov.microservices.limitsservice.config.AppProperties;
import com.dsumtsov.microservices.limitsservice.dto.LimitConfigurationDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LimitsConfigurationController {

    private final AppProperties properties;

    @GetMapping("/limits")
    public LimitConfigurationDTO retrieveLimitsFromConfiguration() {
        return new LimitConfigurationDTO(properties.getMin(), properties.getMax());
    }
}
