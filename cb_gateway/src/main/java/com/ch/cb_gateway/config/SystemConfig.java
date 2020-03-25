package com.ch.cb_gateway.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@ConfigurationProperties(prefix = "path")
@Data
public class SystemConfig {
    private Set<String> exclude = new HashSet<>();
}
