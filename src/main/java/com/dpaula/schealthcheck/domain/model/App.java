package com.dpaula.schealthcheck.domain.model;

import lombok.Builder;
import lombok.Getter;
import org.apache.commons.lang3.Validate;

import java.util.UUID;

@Getter
@Builder
public class App {
    private UUID id;
    private String name;
    private String address;

    public App(UUID id, String name, String address) {
        Validate.notNull(id);
        Validate.notNull(name);
        Validate.notNull(address);
        this.id = id;
        this.name = name;
        this.address = address;
    }
}
