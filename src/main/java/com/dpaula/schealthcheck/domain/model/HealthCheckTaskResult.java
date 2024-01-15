package com.dpaula.schealthcheck.domain.model;

import com.dpaula.schealthcheck.domain.model.valueobject.HealthCheckConfig;
import com.dpaula.schealthcheck.domain.service.HealthResult;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.Validate;

import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
public class HealthCheckTaskResult {
    private UUID id;
    private UUID taskId;
    private UUID scheduleId;
    private OffsetDateTime createdAt;
    private HealthCheckConfig checkConfig;
    private App app;

    private Status status;
    private Integer responseTime;

    private HealthCheckTaskResult() {
    }

    public HealthCheckTaskResult(UUID id, UUID taskId, UUID scheduleId,
                                 OffsetDateTime createdAt, HealthCheckConfig checkConfig, App app,
                                 Status status, Integer responseTime) {
        Validate.notNull(id);
        Validate.notNull(taskId);
        Validate.notNull(scheduleId);
        Validate.notNull(createdAt);
        Validate.notNull(checkConfig);
        Validate.notNull(app);
        Validate.notNull(status);
        Validate.notNull(responseTime);
        this.id = id;
        this.taskId = taskId;
        this.scheduleId = scheduleId;
        this.createdAt = createdAt;
        this.checkConfig = checkConfig;
        this.app = app;
        this.status = status;
        this.responseTime = responseTime;
    }

    public static HealthCheckTaskResult of(HealthCheckTask task, HealthResult result) {
        return HealthCheckTaskResult.builder()
                .id(UUID.randomUUID())
                .taskId(task.getId())
                .createdAt(OffsetDateTime.now())
                .scheduleId(task.getScheduleId())
                .checkConfig(task.getCheckConfig())
                .app(task.getApp())
                .status(result.getStatus())
                .responseTime(result.getResponseTime())
                .build();
    }

    public enum Status {
        UP,DOWN,UNKNOWN
    }
}
