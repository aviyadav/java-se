package com.sample.db.postgres.jsonb.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
    "com.sample.db.postgres.jsonb.config",
    "com.sample.db.postgres.jsonb.controller",
    "com.sample.db.postgres.jsonb.data.entity",
    "com.sample.db.postgres.jsonb.data.repository",
    "com.sample.db.postgres.jsonb.error",
    "com.sample.db.postgres.jsonb.model",
    "com.sample.db.postgres.jsonb.service"})
public class BookApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookApplication.class, args);
    }
}
