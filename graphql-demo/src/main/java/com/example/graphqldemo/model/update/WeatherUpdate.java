package com.example.graphqldemo.model.update;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class WeatherUpdate extends BaseModelUpdate{

    private String base;

    private Integer visibility;

    private Long dateTimeCalculation;

    private Integer timezone;

    private String name;

    private String cod;

    private WeatherCoordinateUpdate weatherCoordinates;

    private WeatherMainUpdate weatherMain;

    private WeatherWindUpdate weatherWind;

    private WeatherCloudUpdate weatherCloud;

    private WeatherRainUpdate weatherRain;

    private WeatherSnowUpdate weatherSnow;

    private WeatherSunUpdate weatherSun;

    private List<WeatherCodeUpdate> codes = new ArrayList<>();
}
