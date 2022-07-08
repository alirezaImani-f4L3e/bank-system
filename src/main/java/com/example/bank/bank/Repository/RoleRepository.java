package com.example.bank.bank.Repository;

import com.example.bank.bank.Models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,String> {

    Role findByTitle(String title);
}
