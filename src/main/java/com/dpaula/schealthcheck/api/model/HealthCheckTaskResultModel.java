package com.dpaula.schealthcheck.api.model;

import com.dpaula.schealthcheck.domain.model.HealthCheckTaskResult;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HealthCheckTaskResultModel {
    private UUID id;
    private UUID taskId;
    private UUID scheduleId;
    private UUID appId;
    private OffsetDateTime createdAt;
    private HealthCheckConfigModel checkConfig;
    private HealthCheckTaskResult.Status status;
    private Integer responseTime;
}
