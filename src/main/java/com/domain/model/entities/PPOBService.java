package com.domain.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class PPOBService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String serviceCode;
    private String serviceName;
    private String serviceIcon;
    private BigDecimal serviceTariff;

    public PPOBService() {
    }

    public PPOBService(String serviceCode, String serviceName, String serviceIcon, BigDecimal serviceTariff) {
        this.serviceCode = serviceCode;
        this.serviceName = serviceName;
        this.serviceIcon = serviceIcon;
        this.serviceTariff = serviceTariff;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceIcon() {
        return serviceIcon;
    }

    public void setServiceIcon(String serviceIcon) {
        this.serviceIcon = serviceIcon;
    }

    public BigDecimal getServiceTariff() {
        return serviceTariff;
    }

    public void setServiceTariff(BigDecimal serviceTariff) {
        this.serviceTariff = serviceTariff;
    }
}
