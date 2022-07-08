package com.example.bank.bank.Controllers;

import com.example.bank.bank.Models.User;
import com.example.bank.bank.Repository.UserRepository;
import com.example.bank.bank.Services.UserService;
import com.example.bank.bank.dataTypes.Gender;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/admin") @RequiredArgsConstructor
public class AdminController {

    private final UserService userService;

    @GetMapping (path = "/users")
    ResponseEntity<List<User>>  getUsers(){

        return ResponseEntity.ok().body(userService.getUsers());
    }

 @PostMapping(path = "/users/create")
  ResponseEntity<User> createUser(@RequestBody User user){
     URI uri =URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/customers/create").toUriString());
     return ResponseEntity.created(uri).body(userService.saveUser(user));
 }



// @PutMapping(path= "/customers/{id}/update")
//     Customer updateCustomer(@RequestBody Customer customer  ,@PathVariable String id){
//    return userRepository.findById(id).map(newCustomer->
//    {
//        newCustomer.setFirst_name(customer.getFirst_name());
//        newCustomer.setLast_name(customer.getLast_name());
//        newCustomer.setBirth_date(customer.getBirth_date());
//        newCustomer.setGender(customer.getGender());
//        newCustomer.setMobile(customer.getMobile());
//        newCustomer.setPassword(customer.getPassword());
//        return userRepository.save(newCustomer);
//    }).orElseGet(() -> {
//        customer.setId(id);
//        return userRepository.save(customer);
//    });
//
// }
}
