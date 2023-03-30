package com.example.graphqldemo.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.example.graphqldemo.cache.CacheModel;
import com.example.graphqldemo.cache.WeatherCache;
import com.example.graphqldemo.config.OpenWeatherApiConfig;
import com.example.graphqldemo.exception.CommonBusinessException;
import com.example.graphqldemo.helper.RestClientSupport;
import com.example.graphqldemo.model.dto.WeatherDTO;
import com.example.graphqldemo.service.OpenWeatherService;
import com.example.graphqldemo.utils.CacheUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class OpenWeatherServiceImpl extends RestClientSupport implements OpenWeatherService {

    private static final String APP_KEY = "appid";

    private static final String CITY_KEY = "q";

    private static final String MESSAGE_CITY_NOT_FOUND_FROM_OPEN_WEATHER = "city not found";

    @Autowired
    private OpenWeatherApiConfig config;

    @Override
    public WeatherDTO getCurrentWeather(String cityName) {
        if (Objects.isNull(cityName) || cityName.trim().length() == 0) {
            throw new CommonBusinessException("City name is required", HttpStatus.BAD_REQUEST.value());
        }
        String keyCache = CacheUtils.getCacheKeyForCurrentWeather(cityName);
        CacheModel<WeatherDTO> cacheData = WeatherCache.getData(keyCache);
        if (Objects.nonNull(cacheData)) {
            return cacheData.getData();
        }
        try {
            Map<String, Object> params = new HashMap<>();
            params.put(CITY_KEY, cityName);
            params.put(APP_KEY, config.getKey());
            WeatherDTO result = get(config.getCurrentWeatherUrl(), null, new TypeReference<WeatherDTO>() {
            }, params);
            WeatherCache.putData(keyCache, result, 5000L);
            return result;
        } catch (HttpStatusCodeException e) {
            // case not found city from external API
            if (HttpStatus.NOT_FOUND.equals(e.getStatusCode()) && Objects.requireNonNull(e.getMessage()).contains(MESSAGE_CITY_NOT_FOUND_FROM_OPEN_WEATHER)) {
                throw new CommonBusinessException("City Not found", HttpStatus.NOT_FOUND.value());
            }
            throw new CommonBusinessException(e.getMessage(), e.getStatusCode().value());
        }
    }

}
