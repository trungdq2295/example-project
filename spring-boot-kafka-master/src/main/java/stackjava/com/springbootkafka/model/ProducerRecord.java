package stackjava.com.springbootkafka.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProducerRecord<K,V> {

    private String topic;

    private K key;

    private V value;

    private Integer partition;

    public ProducerRecord(String topic, K key, V value) {
        this.topic = topic;
        this.key = key;
        this.value = value;
    }
}

