package stackjava.com.springbootkafka.configuration;


import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import stackjava.com.springbootkafka.model.ProducerRecord;
import stackjava.com.springbootkafka.model.deserializer.StudentDeserializer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {
    @Bean
    public ConsumerFactory<String, ProducerRecord> consumerFactory() {
        Map<String, Object> props = new HashMap<>();
//        JsonDeserializer<ProducerRecord>
//                deserializer = new JsonDeserializer<>();
//        deserializer.addTrustedPackages("*");
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "group-id");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StudentDeserializer.class);
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "100");
        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "15000");
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
        return new DefaultKafkaConsumerFactory<>(props);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, ProducerRecord> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, ProducerRecord>
                factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }

//    @Bean
//    DefaultKafkaConsumerFactory kafkaConsumerFactory(KafkaProperties properties, ObjectMapper objectMapper) {
//        Map<String, Object> consumerProperties = properties.buildConsumerProperties();
//        JsonDeserializer<Object> jsonDeserializer = new JsonDeserializer<>(objectMapper);
//        jsonDeserializer.configure(consumerProperties, false);
//
//        return new DefaultKafkaConsumerFactory(consumerProperties,
//                new StringDeserializer(), jsonDeserializer);
//    }

//    @Bean
//    public StringJsonMessageConverter jsonConverter() {
//        return new StringJsonMessageConverter();
//    }

}