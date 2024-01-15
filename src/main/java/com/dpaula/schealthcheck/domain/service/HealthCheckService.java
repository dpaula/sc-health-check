package com.dpaula.schealthcheck.domain.service;

import com.dpaula.schealthcheck.domain.model.App;
import com.dpaula.schealthcheck.domain.model.HealthCheckTask;
import com.dpaula.schealthcheck.domain.model.HealthCheckTaskResult;
import com.dpaula.schealthcheck.domain.model.valueobject.HealthCheckType;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.Validate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class HealthCheckService {

    public HealthCheckTaskResult checkIfIsUp(HealthCheckTask task) {
        Validate.notNull(task);
        App app = task.getApp();
        log.info("Checando app: "  + app.getAddress());

        HealthCheckType type = task.getCheckConfig().getType();
        HealthResult result = type.getHealthChecker().execute(task);

        return HealthCheckTaskResult.of(task, result);
    }
}
