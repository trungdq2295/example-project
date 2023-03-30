package com.example.graphqldemo.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WeatherWindDTO {

    private Double speed;

    private Double deg;

    private Double gust;
}
