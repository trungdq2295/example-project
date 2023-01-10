package com.example.kafkaexample.model.classserializer;

import com.example.kafkaexample.model.DriverLocation;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serializer;

public class DriverLocationSerializer implements Serializer<DriverLocation> {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public byte[] serialize(final String topic, final DriverLocation data) {
        try {
            return objectMapper.writeValueAsString(data).getBytes();
        } catch (Exception e) {
            throw new IllegalArgumentException("Cannot serialize message to json");
        }
    }
}
