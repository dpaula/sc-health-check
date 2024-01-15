package com.dpaula.schealthcheck.api.processor;

import com.dpaula.schealthcheck.api.model.HealthCheckTaskRequest;
import com.dpaula.schealthcheck.api.model.HealthCheckTaskResultModel;
import com.dpaula.schealthcheck.core.Mapper;
import com.dpaula.schealthcheck.domain.model.HealthCheckTask;
import com.dpaula.schealthcheck.domain.service.HealthCheckService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.function.Function;

/**
 * @author Fernando de Lima on 14/01/24
 */
@Component
@RequiredArgsConstructor
public class HealthCheckTaskCommandProcessor implements
        Function<HealthCheckTaskRequest, HealthCheckTaskResultModel> {

    private final Mapper mapper;
    private final HealthCheckService healthCheckService;

    @Override
    public HealthCheckTaskResultModel apply(HealthCheckTaskRequest request) {
        final var task = request.toDomain();
        final var result = healthCheckService.checkIfIsUp(task);

        return mapper.map(result, HealthCheckTaskResultModel.class);
    }
}
