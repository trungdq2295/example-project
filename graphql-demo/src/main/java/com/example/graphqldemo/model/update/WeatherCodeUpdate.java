package com.example.graphqldemo.model.update;

import com.example.graphqldemo.enumeration.WeatherCodeMainEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Size;

@EqualsAndHashCode(callSuper = true)
@Data
public class WeatherCodeUpdate extends BaseModelUpdate {


    private WeatherCodeMainEnum main;

    @Size(max = 200)
    private String description;

    @Size(max = 20)
    private String icon;
}
