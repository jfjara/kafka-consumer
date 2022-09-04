package org.jfjara.consumer.factory;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class KafkaConsumerFactory {

    @Qualifier("consumerConfig")
    @Autowired
    private Properties kafkaProperties;

    public KafkaConsumer<String, String> getInstance() {
        return new KafkaConsumer<String, String>(kafkaProperties);
    }


}
