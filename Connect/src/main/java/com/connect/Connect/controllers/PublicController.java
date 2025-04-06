package com.connect.Connect.controllers;


import com.connect.Connect.exceptions.WeatherServiceException;
import com.connect.Connect.services.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}