package org.jfjara.consumer.client;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.jfjara.consumer.factory.KafkaConsumerFactory;
import org.jfjara.consumer.mapper.KafkaConsumerMapper;
import org.jfjara.consumer.model.KafkaCustomValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class KafkaClient {

    @Autowired
    private KafkaConsumerFactory kafkaConsumerFactory;

    @Autowired
    private KafkaConsumerMapper kafkaConsumerMapper;

    KafkaConsumer<String, String> consumer;

    public void init(final String topic) {
        consumer = kafkaConsumerFactory.getInstance();
        consumer.subscribe(Collections.singletonList(topic));
    }

    public List<KafkaCustomValue> consume() {
        List<KafkaCustomValue> result = new ArrayList<>();
        ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(1));
        records.forEach(r -> result.add(kafkaConsumerMapper.toCustomModel(r)));
        return result;
    }


}
