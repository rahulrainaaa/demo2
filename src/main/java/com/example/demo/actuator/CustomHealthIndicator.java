package com.example.demo.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        // Custom health check logic, for example, checking database connectivity
        boolean databaseConnectionHealthy = checkDatabaseConnection();

        if (databaseConnectionHealthy) {
            return Health.up().withDetail("database", "Connected").build();
        } else {
            return Health.down().withDetail("database", "Connection failed").build();
        }
    }

    private boolean checkDatabaseConnection() {
        // Add your database connection check logic here (e.g., test query)
        // For this example, we simulate a successful connection
        return false;
    }
}
