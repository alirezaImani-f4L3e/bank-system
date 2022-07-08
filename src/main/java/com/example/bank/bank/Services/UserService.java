package com.example.bank.bank.Services;

import com.example.bank.bank.Models.User;
import com.example.bank.bank.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor @Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String national_id) throws UsernameNotFoundException {
        User user = userRepository.findByNationalId(national_id);

        if(user== null){
            throw  new UsernameNotFoundException("user not found");
        }

        Collection<SimpleGrantedAuthority> authorities =new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getTitle()));
        });


        return new org.springframework.security.core.userdetails.User(user.getNationalId() , user.getPassword() ,authorities);
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User getUser(String nationalId){
        return userRepository.findByNationalId(nationalId);
    }

    public User saveUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
