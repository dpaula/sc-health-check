package com.dpaula.schealthcheck.domain.service;


import com.dpaula.schealthcheck.domain.model.HealthCheckTask;

public interface HealthChecker {
    HealthResult execute(HealthCheckTask task);
}
