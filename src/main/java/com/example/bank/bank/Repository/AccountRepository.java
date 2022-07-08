package com.example.bank.bank.Repository;

import com.example.bank.bank.Models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account , String> {
    public Account findByAccountNumber(String accountNumber);
}
