package com.domain.model.transaction;

import java.time.LocalDateTime;

public class TransactionResult {
    private String invoiceNumber;
    private String serviceCode;
    private String serviceName;
    private String transactionType;
    private int totalAmount;
    private LocalDateTime createdOn;

    public TransactionResult(String invoiceNumber, String serviceCode, String serviceName, String transactionType, int totalAmount, LocalDateTime createdOn) {
        this.invoiceNumber = invoiceNumber;
        this.serviceCode = serviceCode;
        this.serviceName = serviceName;
        this.transactionType = transactionType;
        this.totalAmount = totalAmount;
        this.createdOn = createdOn;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }
}

