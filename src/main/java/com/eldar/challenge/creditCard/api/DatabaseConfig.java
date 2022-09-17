package com.eldar.challenge.creditCard.api;

import com.zaxxer.hikari.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Value("${postgres://kvkwjgccvhgjij:d3eeb1e725bd225387cfc25346fed4cddbf60e8afc320255928ebb3929bbdc4a@ec2-3-93-206-109.compute-1.amazonaws.com:5432/d5gs260080ltkc}")
    private String dbUrl;

    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(dbUrl);
        return new HikariDataSource(config);
    }
}