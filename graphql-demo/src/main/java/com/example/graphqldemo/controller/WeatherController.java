package com.example.graphqldemo.controller;

import com.example.graphqldemo.model.dto.WeatherDTO;
import com.example.graphqldemo.service.OpenWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class WeatherController {

    @Autowired
    private OpenWeatherService openWeatherService;

    @QueryMapping
    public WeatherDTO getWeatherByCityName(@Argument String cityName){
        return openWeatherService.getCurrentWeather(cityName);
    }
}
