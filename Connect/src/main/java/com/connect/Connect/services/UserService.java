package com.connect.Connect.services;


import com.connect.Connect.entries.User;
import com.connect.Connect.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserService
{

    @Autowired
    private UserRepository userRepository;

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    public String createNewAccount(User user) throws Exception {
        User db_user = userRepository.findByusername(user.getUsername());
        if (db_user!=null){
            throw new Exception("User already exist");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("USER");
        user.setLocalDate(LocalDate.now());
        userRepository.save(user);
        return "Account created";
    }

    public User getUserDetails(String name)
    {
        return userRepository.findByusername(name);
    }

    public String deleteByUserName(String name) {
        userRepository.deleteById(userRepository.findByusername(name).getId());
        return "Account deleted.";
    }

    public User updateUserDetails(User user, String name) {

        User db_user = userRepository.findByusername(name);
        db_user.setUsername(user.getUsername());
        db_user.setPassword(passwordEncoder.encode(user.getPassword()));
        db_user.setEmail_address(user.getEmail_address());
        userRepository.save(db_user);
        return db_user;
    }
}
