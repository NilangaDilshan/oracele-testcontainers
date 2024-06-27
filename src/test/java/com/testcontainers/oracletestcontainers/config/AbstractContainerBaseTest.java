package com.testcontainers.oracletestcontainers.config;

import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.oracle.OracleContainer;

public abstract class AbstractContainerBaseTest {

    static final OracleContainer ORACLE_CONTAINER;

    static {
        ORACLE_CONTAINER = new OracleContainer("gvenzl/oracle-free:latest")
                .withDatabaseName("testdb")
                .withUsername("testuser")
                .withPassword("testpass");
        ORACLE_CONTAINER.start();
    }

    @DynamicPropertySource
    public static void dynamicPropertySource(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", ORACLE_CONTAINER::getJdbcUrl);
        registry.add("spring.datasource.username", ORACLE_CONTAINER::getUsername);
        registry.add("spring.datasource.password", ORACLE_CONTAINER::getPassword);
        registry.add("spring.datasource.driver-class-name", () -> "oracle.jdbc.OracleDriver");
    }
}