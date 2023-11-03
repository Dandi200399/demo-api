package com.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.domain.model.repository.ServiceRepository;

@Service
public class ServiceService {
    private final ServiceRepository serviceRepository;

    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public List<java.security.Provider.Service> getAllServices() {
        return serviceRepository.findAll();
    }
}
