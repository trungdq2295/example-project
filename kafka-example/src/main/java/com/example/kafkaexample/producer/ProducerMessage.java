package com.example.kafkaexample.producer;


import com.example.kafkaexample.model.ProducerRecord;
import com.example.kafkaexample.model.Student;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ProducerMessage {

    private KafkaTemplate<String, Object> kafkaTemplate;

    private ProducerFactory<String, Object> producerFactory;

    public ProducerMessage(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    private static final String KAFKA_TOPIC = "new-kafka-topic";
    private static final String TRANSACTION_TOPIC_1 = "transaction-topic-1";
    private static final String TRANSACTION_TOPIC_2 = "transaction-topic-2";

    @Transactional
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

    @Transactional
    public void runProducerTransaction() {
        try {
            sendMessage(TRANSACTION_TOPIC_1, String.valueOf(4));
            Thread.sleep(4000);
            sendMessage(TRANSACTION_TOPIC_2, String.valueOf(7));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendMessage(String topic, String msg) {
        ProducerRecord<String, String> producerRecord = new ProducerRecord<>(topic, "key-" + msg, "message-" + msg);
        kafkaTemplate.send(topic, 2, producerRecord.getKey(), producerRecord);
    }

    private void sendMessage(String topic) {
        Student student = new Student(1,"TN");
        kafkaTemplate.send(topic, student);
    }
}
