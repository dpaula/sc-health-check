package com.dpaula.schealthcheck.api.model;

import com.dpaula.schealthcheck.domain.model.valueobject.HealthCheckType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HealthCheckConfigModel {
    @NotNull
    private HealthCheckType type;
    @NotNull
    private Integer timeout;
}
