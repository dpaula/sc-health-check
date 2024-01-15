package com.dpaula.schealthcheck.domain.service;

import com.dpaula.schealthcheck.domain.model.HealthCheckTaskResult;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HealthResult {
    private HealthCheckTaskResult.Status status;
    private Integer responseTime;
}
