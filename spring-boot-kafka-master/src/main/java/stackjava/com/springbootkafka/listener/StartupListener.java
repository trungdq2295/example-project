package stackjava.com.springbootkafka.listener;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import stackjava.com.springbootkafka.model.Student;

@Component
public class StartupListener {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    @KafkaListener(topics = "new-kafka-topic", groupId = "group-id")
    public void listen(@Payload Student message) {
        System.out.println("Received Message in group - group-id: " + message);
    }
}
