package com.example.bank.bank.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Account {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String accountNumber ;
    private double balance;
    private String type ; //longTime shortTime jari
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private LocalDate FreezeExpiration;

    @OneToMany
    private Collection<Transaction> transactions =new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;
}
