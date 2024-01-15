package com.dpaula.schealthcheck.domain.model.valueobject;

import lombok.Builder;
import lombok.Getter;
import org.apache.commons.lang3.Validate;

@Getter
@Builder
public class HealthCheckConfig {
    private HealthCheckType type;
    private Integer timeout;

    public HealthCheckConfig(HealthCheckType type, Integer timeout) {
        Validate.notNull(type);
        Validate.notNull(timeout);
        this.type = type;
        this.timeout = timeout;
    }
}
