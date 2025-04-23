package com.bony.project_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class DatabaseConnectionTest {

    public static void main(String[] args) {
        SpringApplication.run(DatabaseConnectionTest.class, args);
    }

    @Bean
    public CommandLineRunner testConnection(JdbcTemplate jdbcTemplate) {
        return args -> {
            System.out.println("Testing PostgreSQL connection...");
            try {
                Integer result = jdbcTemplate.queryForObject("SELECT 1", Integer.class);
                if (result != null && result == 1) {
                    System.out.println("Database connection successful! Query result: " + result);
                } else {
                    System.out.println("Unexpected query result.");
                }
            } catch (Exception e) {
                System.err.println("Database connection failed: " + e.getMessage());
            }
        };
    }
}