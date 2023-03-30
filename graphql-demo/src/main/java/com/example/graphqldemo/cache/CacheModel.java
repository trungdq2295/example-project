package com.example.graphqldemo.cache;

import lombok.Data;

@Data
public class CacheModel<T> {

    private T data;

    private Long expiredTime;
}
