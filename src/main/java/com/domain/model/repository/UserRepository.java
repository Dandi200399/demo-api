package com.domain.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.domain.model.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Object findByUsername(String username);
    // Metode khusus jika diperlukan
}

