package com.excercise.redisexample.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@Log4j2
public class RedisUtility {

    private static ObjectMapper objectMapper = new ObjectMapper();

    @Qualifier("redisTemplate")
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public <T> void setValue(final String key, T data) {
        try {
            redisTemplate.opsForValue().set(key, objectMapper.writeValueAsString(data));
            redisTemplate.expire(key, 10, TimeUnit.MINUTES);
        } catch (Exception e) {
            log.error("Failed to save value to Redis ", e.getCause());
        }
    }

    public <T> T getValue(final String key, TypeReference<T> typeRef) {
        try {
            return objectMapper.readValue(redisTemplate.opsForValue().get(key), typeRef);
        } catch (Exception e) {
            log.error("Failed to save value to Redis ", e.getCause());
        }
        return null;
    }

    public void deleteKeyFromRedis(String key) {
        redisTemplate.delete(key);
    }
}
