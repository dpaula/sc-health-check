package com.dpaula.schealthcheck.domain.model.valueobject;

import com.dpaula.schealthcheck.domain.service.HealthChecker;
import com.dpaula.schealthcheck.infra.HttpHealthChecker;
import com.dpaula.schealthcheck.infra.PingHealthChecker;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum HealthCheckType {
    HTTP(new HttpHealthChecker()),
    PING(new PingHealthChecker());

    private final HealthChecker healthChecker;

    public HealthChecker getHealthChecker() {
        return healthChecker;
    }
}
