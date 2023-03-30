package com.example.graphqldemo.model.update;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class WeatherCloudUpdate extends BaseModelUpdate{

    private Double allPercentages;

}
