package com.dsumtsov.microservices.limitsservice.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("limits-service")
@Getter
@Setter
public class AppProperties {
    private int min;
    private int max;
}
