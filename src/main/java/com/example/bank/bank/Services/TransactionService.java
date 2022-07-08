package com.example.bank.bank.Services;

import com.example.bank.bank.Repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service @RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;
}
