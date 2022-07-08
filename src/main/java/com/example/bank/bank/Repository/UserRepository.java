package com.example.bank.bank.Repository;

import com.example.bank.bank.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    User findByNationalId(String nationalId);
}
