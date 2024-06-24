package com.faruoqi.microservices.core.review;

import org.springframework.test.context.DynamicPropertyRegistry;
import org.testcontainers.containers.JdbcDatabaseContainer;
import org.testcontainers.containers.MySQLContainer;

public abstract class MysqlTestBase {
    private static JdbcDatabaseContainer database =
            new MySQLContainer("mysql:8.0.32").withStartupTimeoutSeconds(300);


    static {
        database.start();
    }

    static void databaseProperties(DynamicPropertyRegistry registry){
        registry.add("spring.datasource.url", database::getJdbcUrl);
        registry.add("spring.datasource.username", database::getUsername);
        registry.add("spring.datasource.password", database::getPassword);

    }
}
