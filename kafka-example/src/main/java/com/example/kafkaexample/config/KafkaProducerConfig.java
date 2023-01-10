package com.example.kafkaexample.config;

import com.example.kafkaexample.model.classserializer.StudentSerializer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.Serializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.kafka.transaction.KafkaTransactionManager;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {
    @Bean
    public ProducerFactory<String, Object> producerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.CLIENT_ID_CONFIG, "java-producer");
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092,localhost:9093");
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StudentSerializer.class);
//        configProps.put(JsonSerializer.TYPE_MAPPINGS, "student:com.example.kafkaexample.model.Student");
        //set up Idempotent to make sure when retry on sending message it won't be duplicated
        configProps.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, "true");
        // Create Transaction when send message to a topic or multiple topics
        // Need to add @Transaction on each function when we add this config
        configProps.put(ProducerConfig.TRANSACTIONAL_ID_CONFIG, "demo-transaction-id");
        return new DefaultKafkaProducerFactory<>(configProps);
    }
    @Bean
    public KafkaTemplate<String, Object> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

    @Bean("controlTransactionManager")
    public KafkaTransactionManager<String, Object> transactionManager() {
        return new KafkaTransactionManager<>(producerFactory());
    }

}
