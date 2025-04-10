package com.connect.Connect.controllers;


import com.connect.Connect.entries.User;
import com.connect.Connect.exceptions.WeatherServiceException;
import com.connect.Connect.services.EmailService;
import com.connect.Connect.services.UserService;
import com.connect.Connect.services.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/public")
@RequiredArgsConstructor
public class PublicController
{

    Integer temperature;
    List<String > weather_description;
    private static final String HEALTH_CHECK_SUCCESS = "OK";


    @Autowired
    private WeatherService weatherService;


    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;


    @GetMapping("/health-check")
    public ResponseEntity<String> healthCheck() {
        return new ResponseEntity<>(HEALTH_CHECK_SUCCESS,HttpStatus.OK);
    }


    @GetMapping("/weather-check/{city}")
    public ResponseEntity<?> weatherCheck(@PathVariable String city){
        try{
            temperature = weatherService.getWeather(city).getCurrent().getTemperature();
            weather_description = weatherService.getWeather(city).getCurrent().getWeatherDescriptions();
            return new ResponseEntity<>(temperature+" "+weather_description,HttpStatus.OK);
        } catch (WeatherServiceException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }


    @PostMapping("/signup")
    public ResponseEntity<?> createNewAccount(@RequestBody User user){
        try {
            return new ResponseEntity<>(userService.createNewAccount(user),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/sendmail")
    public void sendMail(){
        emailService.sendSimpleEmail("shaikhhamza0522@gmail.com","Spring boot demo", "Test");
    }
}