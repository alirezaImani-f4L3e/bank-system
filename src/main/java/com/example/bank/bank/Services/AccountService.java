package com.example.bank.bank.Services;

import com.example.bank.bank.Models.Account;
import com.example.bank.bank.Repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service @RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

    public Account saveAccount(Account account){
        return accountRepository.save(account);
    }

    public Account getAccount(String accountNumber){
        return accountRepository.findByAccountNumber(accountNumber);
    }

    public void deleteAccount(Account account){
         accountRepository.delete(account);
    }
}
