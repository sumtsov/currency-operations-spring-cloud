package com.dsumtsov.microservices.limitsservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LimitConfigurationDTO {
    private int min;
    private int max;
}
