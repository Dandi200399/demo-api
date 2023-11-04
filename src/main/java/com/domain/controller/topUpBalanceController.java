package com.domain.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.domain.model.ApiResponse;
import com.domain.model.BalanceResponse;
import com.domain.model.TopUpRequest;

@RestController
@RequestMapping("/transaction")
public class topUpBalanceController {

    // Mendefinisikan metode untuk melakukan top up saldo
    @PostMapping("/topup")
    public ResponseEntity<ApiResponse> topUpBalance(@RequestBody TopUpRequest request) {
        // Validasi parameter amount
        if (request.getTopUpAmount() <= 0) {
            ApiResponse errorResponse = new ApiResponse(102, "Paramter amount hanya boleh angka dan tidak boleh lebih kecil dari 0", null);
            return ResponseEntity.badRequest().body(errorResponse);
        }

        // Simulasikan penambahan saldo (gantilah ini dengan logika sebenarnya)
        long currentBalance = getCurrentBalance(); // Gantilah dengan cara yang sesuai
        long newBalance = currentBalance + request.getTopUpAmount();
        updateBalanceInDatabase(newBalance); // Gantilah dengan cara yang sesuai

        // Simulasikan pengaturan transaction_type (gantilah ini dengan logika sebenarnya)
        setTransactionTypeInDatabase("TOPUP"); // Gantilah dengan cara yang sesuai

        // Membuat respons
        BalanceResponse response = new BalanceResponse(newBalance);
        ApiResponse apiResponse = new ApiResponse(0, "Top Up Balance berhasil", response);

        return ResponseEntity.ok(apiResponse);
    }

    private void setTransactionTypeInDatabase(String string) {
    }

    private void updateBalanceInDatabase(long newBalance) {
    }

    private long getCurrentBalance() {
        return 0;
    }
}

