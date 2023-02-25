package com.example.kafkaexample.producer;


import com.example.kafkaexample.model.ProducerRecord;
import com.example.kafkaexample.model.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ProducerMessage {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final ObjectMapper objectMapper = new ObjectMapper();

    private ProducerFactory<String, Object> producerFactory;

    private static final String KAFKA_TOPIC = "new-kafka-topic";
    private static final String TRANSACTION_TOPIC_1 = "quickstart";
    private static final String TRANSACTION_TOPIC_2 = "transaction-topic-2";

    public void run() {
        try {
            sendMessage(KAFKA_TOPIC);
//            for (int i = 0; i < 40; i++) {
//                sendMessage(KAFKA_TOPIC, String.valueOf(i));
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void runProducerTransaction() {
        try {
            sendMessage(TRANSACTION_TOPIC_1, String.valueOf(4));
            Thread.sleep(4000);
//            sendMessage(TRANSACTION_TOPIC_2, String.valueOf(7));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void runWithParam(String message) {
        try {
            sendMessage(TRANSACTION_TOPIC_1, message);
            Thread.sleep(4000);
//            sendMessage(TRANSACTION_TOPIC_2, String.valueOf(7));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendMessage(String topic, String msg) throws JsonProcessingException {
        ProducerRecord<String, String> producerRecord = new ProducerRecord<>(topic, "key-" + msg, "message-" + msg);
        Student student = new Student(1,msg);
        kafkaTemplate.send(topic, objectMapper.writeValueAsString(student));
    }

    private void sendMessage(String topic) {
//        Student student = new Student(1,"TN");
//        kafkaTemplate.send(topic, student);
    }
}
