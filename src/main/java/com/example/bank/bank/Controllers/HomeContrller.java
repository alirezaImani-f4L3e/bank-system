package com.example.bank.bank.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController @RequestMapping(path="/api")
public class HomeContrller {
    @GetMapping(path = "/")
    ResponseEntity<String> index(){
        return ResponseEntity.ok().body("welcome to farabi bank api");
    }
}
