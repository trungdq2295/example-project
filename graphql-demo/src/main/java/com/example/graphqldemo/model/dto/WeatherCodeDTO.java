package com.example.graphqldemo.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WeatherCodeDTO {

    private Long id;

    private String main;

    private String description;

    private String icon;
}
