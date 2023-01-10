package com.example.kafkaexample.model.classserializer;

import com.example.kafkaexample.model.DriverLocation;
import com.example.kafkaexample.model.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serializer;

public class StudentSerializer implements Serializer<Student> {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public byte[] serialize(final String topic, final Student data) {
        try {
            return objectMapper.writeValueAsString(data).getBytes();
        } catch (Exception e) {
            throw new IllegalArgumentException("Cannot serialize message to json");
        }
    }
}
