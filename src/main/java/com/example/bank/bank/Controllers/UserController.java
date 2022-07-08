package com.example.bank.bank.Controllers;

import com.example.bank.bank.Models.User;
import com.example.bank.bank.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping(path = "/api/users") @RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(path = "/{nationalId}")
    ResponseEntity<User> getCustomer(@PathVariable String nationalId){
        return ResponseEntity.ok().body(userService.getUser(nationalId));
    }

}
