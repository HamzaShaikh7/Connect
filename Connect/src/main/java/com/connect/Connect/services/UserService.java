package com.connect.Connect.services;


import com.connect.Connect.entries.User;
import com.connect.Connect.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class UserService
{

    @Autowired
    private UserRepository userRepository;


    public String createNewAccount(User user) throws Exception {
        User db_user = userRepository.findByusername(user.getUsername());
        if (db_user!=null){
            throw new Exception("User already exist");
        }
        user.setRole("USER");
        user.setLocalDate(LocalDate.now());
        userRepository.save(user);
        return "Account created";
    }
}
