package stackjava.com.springbootkafka.listener;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "quickstart", groupId = "group-quickstart")
    public void listen(String message) throws JsonProcessingException {
        System.out.println("Received Message in group - name: " + objectMapper.readValue(message, Student.class).getName());
    }

    @KafkaListener(topics = "quickstart", groupId = "group-quickstart-2")
    public void listenABC(String message) throws JsonProcessingException {
        System.out.println("Received Message in group - Id " + objectMapper.readValue(message, Student.class).getId());
    }
}
