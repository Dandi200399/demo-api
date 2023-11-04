package com.domain.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.domain.model.ApiResponse;
import com.domain.model.BalanceResponse;

@RestController
@RequestMapping("/transaction")
public class BalanceController {
    
    @GetMapping("/balance")
    public ResponseEntity<ApiResponse> getBalance() {
        // Gantilah nilai saldo sesuai dengan cara Anda mengambilnya dari database atau sumber lainnya
        long balance = 1000000;
        
        // Membuat respons dengan menggunakan ApiResponse
        ApiResponse response = new ApiResponse(0, "Get Balance Berhasil", new BalanceResponse(balance));
        
        return ResponseEntity.ok(response);
    }
}
