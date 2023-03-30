package com.example.graphqldemo.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WeatherCoordinateDTO {

    private Double lon;

    private Double lat;
}
