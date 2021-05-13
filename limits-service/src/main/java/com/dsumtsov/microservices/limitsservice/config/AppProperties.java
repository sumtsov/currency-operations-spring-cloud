package com.dsumtsov.microservices.limitsservice.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("limits-service")
public class AppProperties {

    private int min;
    private int max;
}
