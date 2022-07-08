package com.example.bank.bank.Controllers;

import com.example.bank.bank.Models.Account;
import com.example.bank.bank.Models.User;
import com.example.bank.bank.Repository.UserRepository;
import com.example.bank.bank.Services.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor @RequestMapping(path="/api/accounts")
public class AccountController {

    private final AccountService accountService;
    private final UserRepository userRepository;

    @PostMapping(path = "/create/{userNationalId}")
    ResponseEntity<Account> createAccount(@RequestBody Account account , @PathVariable String userNationalId){
        User user =userRepository.findByNationalId(userNationalId);
        account.setUser(user);
        return ResponseEntity.ok().body(accountService.saveAccount(account));
    }

    @DeleteMapping(path = "/delete/{accountNumber}")
    ResponseEntity<Boolean> deleteAccount(@PathVariable String accountNumber){
        Account account =accountService.getAccount(accountNumber);
        try{
            accountService.deleteAccount(account);
        }catch(Exception exception){
            return ResponseEntity.status(400).body(false);
        }
        return ResponseEntity.status(200).body(true);

    }
}
