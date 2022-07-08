package com.example.bank.bank.Models;

import com.example.bank.bank.dataTypes.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.repository.cdi.Eager;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class User {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String first_name;
    private String last_name;
    private String nationalId;
    private String password;
    private String gender;
    private String mobile;
    private LocalDate birthDate;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles =new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL )
    private Collection<Transaction> transactions = new ArrayList<>();

    private LocalDate createdAt;

    private LocalDate updatedAt;
}
