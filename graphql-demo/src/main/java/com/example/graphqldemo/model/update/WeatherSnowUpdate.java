package com.example.graphqldemo.model.update;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class WeatherSnowUpdate extends BaseModelUpdate{

    private Double oneHour;

    private Double threeHours;

    public WeatherSnowUpdate(@JsonProperty("1h") Double oneHour, @JsonProperty("3h") Double threeHours) {
        this.oneHour = oneHour;
        this.threeHours = threeHours;
    }
}
