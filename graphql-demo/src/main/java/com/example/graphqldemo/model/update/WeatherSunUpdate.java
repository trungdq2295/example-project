package com.example.graphqldemo.model.update;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Size;


@EqualsAndHashCode(callSuper = true)
@Data
public class WeatherSunUpdate extends BaseModelUpdate {

    private Integer type;

    private Long id;

    @Size( max = 2, message = "Country code is invalid")
    private String countryCode;

    private Long sunRise;

    private Long sunSet;
}
