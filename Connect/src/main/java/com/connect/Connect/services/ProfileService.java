package com.connect.Connect.services;

import com.connect.Connect.entries.ProfileEntry;
import com.connect.Connect.entries.User;
import com.connect.Connect.repositories.ProfileRepository;
import com.connect.Connect.repositories.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.transform.Result;
import java.time.LocalDateTime;
import java.util.List;


@Component
public class ProfileService {


    @Autowired
    private UserService userService;

    @Autowired
    private ProfileRepository profileRepository;


    @Autowired
    private UserRepository userRepository;


    public String addContent(ProfileEntry profileEntry, String name) throws Exception {
        try {
            User user = userRepository.findByusername(name);
            profileEntry.setDate(LocalDateTime.now());
            ProfileEntry entry = profileRepository.save(profileEntry);
            user.getProfileEntry().add(entry);
            userRepository.save(user);
            return "Profile updated.";
        }catch (Exception e){
            throw new Exception("Inter error occur."+e);
        }

    }


    public boolean deleteById(ObjectId id, String name){

        boolean removed = false;
        User user = userRepository.findByusername(name);
        removed = user.getProfileEntry().removeIf(x -> x.getId().equals(id));
        if(removed){
            userService.saveUser(user);
            profileRepository.deleteById(id);
        }
        return removed;
    }
}
