package com.example.graphqldemo.service;

import com.example.graphqldemo.model.filter.HistoryWeatherFilter;
import com.example.graphqldemo.model.response.Response;
import com.example.graphqldemo.model.update.WeatherUpdate;

import java.util.Map;

public interface WeatherService {

    Response saveWeather(WeatherUpdate update);

    Response editWeather(WeatherUpdate update);

    Map<String, Object> getHistoryWeather(HistoryWeatherFilter filter);

    Response deleteWeatherHistory(Long weatherId);
}
