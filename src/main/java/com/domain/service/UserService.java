package com.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void registerUser(String email, String firstName, String lastName, String password) {
        String sql = "INSERT INTO users (email, first_name, last_name, password) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, email, firstName, lastName, password);
    }
}


