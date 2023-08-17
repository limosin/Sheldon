package com.simpl.sheldon.recommendationapi.configs;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class EnvironmentConfiguration {
    @Value("${active.environment}")
    private String environment;

    public boolean isProduction() {
        return environment.equalsIgnoreCase("production");
    }

    public boolean isStaging() {
        return environment.equalsIgnoreCase("staging");
    }

    public boolean isDevelopment() {
        return environment.equalsIgnoreCase("development");
    }
}
