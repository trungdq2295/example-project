package com.example.graphqldemo.model.update;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class WeatherWindUpdate extends BaseModelUpdate{

    private Double speed;

    private Integer deg;

    private Double gust;
}
