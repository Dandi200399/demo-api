package com.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort; // Menggunakan Sort yang benar
import org.springframework.stereotype.Service;

import com.domain.model.entities.TransactionHistory;
import com.domain.model.repository.TransactionHistoryRepository;

@Service
public class TransactionHistoryService {
    @Autowired
    private TransactionHistoryRepository transactionHistoryRepository;

    public List<TransactionHistory> getTransactionHistory(String userEmail, int offset, Integer limit) {
        Sort sorting = Sort.by(Sort.Order.desc("createdOn"));
        PageRequest pageable = PageRequest.of(offset, limit != null ? limit : Integer.MAX_VALUE, sorting);
        return (List<TransactionHistory>) transactionHistoryRepository.findAll(pageable);
    }
}
