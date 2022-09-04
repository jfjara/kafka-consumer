package org.jfjara.consumer.repository;

import org.jfjara.consumer.client.KafkaClient;
import org.jfjara.consumer.dto.CustomObjectReadedDto;
import org.jfjara.consumer.mapper.KafkaConsumerMapper;
import org.jfjara.consumer.ports.ConsumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KafkaConsumerRepository implements ConsumerRepository {

    @Autowired
    private KafkaClient kafkaClient;

    @Autowired
    private KafkaConsumerMapper kafkaConsumerMapper;

    @Override
    public void init(String topic) {
        kafkaClient.init(topic);
    }

    @Override
    public List<CustomObjectReadedDto> consume() {
        return kafkaConsumerMapper.toDto(kafkaClient.consume());
    }
}
