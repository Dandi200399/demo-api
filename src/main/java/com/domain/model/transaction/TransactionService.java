package com.domain.model.transaction;

import org.springframework.stereotype.Service;


@Service
public class TransactionService {
    public boolean isSufficientBalance(String email, String amount) {
        return false;
        // Implementasi logika untuk memeriksa saldo mencukupi
    }

    public TransactionResult performTransaction(String email, String serviceCode) {
        return null;
        // Implementasi logika untuk melakukan transaksi
    }
}

