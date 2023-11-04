package com.domain.controller;

import java.nio.file.attribute.UserPrincipal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.domain.model.ApiResponse;
import com.domain.model.entities.TransactionHistory;
import com.domain.service.TransactionHistoryService;

@RestController
@RequestMapping("/transaction/history")
public class TransactionHistoryController {
    @Autowired
    private TransactionHistoryService transactionHistoryService;

    @GetMapping
    public ResponseEntity<ApiResponse> getTransactionHistory(
        @RequestParam(name = "offset", defaultValue = "0") int offset,
        @RequestParam(name = "limit", required = false) Integer limit,
        @AuthenticationPrincipal UserPrincipal userPrincipal
    ) {
        String userEmail = userPrincipal.getName();
        List<TransactionHistory> transactionHistories = transactionHistoryService.getTransactionHistory(userEmail, offset, limit);
        ApiResponse response = new ApiResponse(0, "Get History Berhasil", transactionHistories);
        return ResponseEntity.ok(response);
    }
}

