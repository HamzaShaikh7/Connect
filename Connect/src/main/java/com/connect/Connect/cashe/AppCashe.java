package com.connect.Connect.cashe;


import com.connect.Connect.entries.ConfigApiEntry;
import com.connect.Connect.repositories.ConfigAPIRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AppCashe
{

    public static String APP_CASHE = null;


    @Autowired
    private ConfigAPIRepository configAPIRepository;


    @PostConstruct
    public void init(){
        List<ConfigApiEntry> configApiEntries = configAPIRepository.findAll();
        APP_CASHE = configApiEntries.getFirst().getAPI_KEY();
    }
}
