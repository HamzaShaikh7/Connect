package com.connect.Connect.services;


import com.connect.Connect.api.response.WeatherResponse;
import com.connect.Connect.exceptions.WeatherServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Slf4j
@Component
public class WeatherService
{

    @Value("${weather.api.key}")
    private String API_KEY;


    private static final String API = "http://api.weatherstack.com/current?access_key=<api_key>&query=<city>";


    @Autowired
    private RestTemplate restTemplate;


    public WeatherResponse getWeather(String city){

        String FINAL_API = API.replace("<api_key>",API_KEY).replace("<city>",city);
        ResponseEntity<WeatherResponse> response = restTemplate.exchange(FINAL_API, HttpMethod.GET, null, WeatherResponse.class);
        WeatherResponse body = response.getBody();
        if (body == null || body.getCurrent() == null){
            throw new WeatherServiceException("Invalid weather data received");
        }
        return body;
    }
}
