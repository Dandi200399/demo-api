package com.domain.model.repository;

import java.security.Provider.Service;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Long> {
    // Tambahkan metode khusus jika diperlukan
}

