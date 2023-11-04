package com.domain.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.domain.model.ApiResponse;
import com.domain.model.TransactionRequest;
import com.domain.model.transaction.TransactionResult;
import com.domain.model.transaction.TransactionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;
    
    @PostMapping
    public ResponseEntity<?> performTransaction(@RequestBody TransactionRequest request) {
        // Dapatkan email pengguna dari payload JWT
        String userEmail = SecurityContextHolder.getContext().getAuthentication().getName();

        try {
            // Lakukan validasi saldo mencukupi
            boolean isSufficientBalance = transactionService.isSufficientBalance(userEmail, request.getServiceCode());

            if (isSufficientBalance) {
                TransactionResult result = transactionService.performTransaction(userEmail, request.getServiceCode());

                if (result != null) {
                    return ResponseEntity.ok(result);
                } else {
                    return ResponseEntity.badRequest().body(new ApiResponse(102, "Service atau Layanan tidak ditemukan", null));
                }
            } else {
                return ResponseEntity.badRequest().body(new ApiResponse(102, "Saldo tidak mencukupi", null));
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ApiResponse(102, "Gagal melakukan transaksi", null));
        }
    }
}
