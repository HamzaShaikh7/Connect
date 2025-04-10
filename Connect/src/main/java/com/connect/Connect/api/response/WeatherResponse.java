package com.connect.Connect.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;


@Getter
@Setter
public class WeatherResponse
{

    private Current current;

    @Getter
    @Setter
    public static class Current
    {

        @JsonProperty("temperature")
        private int temperature;

        @JsonProperty("weather_descriptions")
        private ArrayList<String> weatherDescriptions;

    }
}