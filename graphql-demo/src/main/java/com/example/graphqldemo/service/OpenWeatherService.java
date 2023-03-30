package com.example.graphqldemo.service;


import com.example.graphqldemo.model.dto.WeatherDTO;

public interface OpenWeatherService {

    WeatherDTO getCurrentWeather(String cityName);
}
