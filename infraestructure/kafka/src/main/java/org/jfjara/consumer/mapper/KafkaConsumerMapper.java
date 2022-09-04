package org.jfjara.consumer.mapper;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.jfjara.consumer.dto.CustomObjectReadedDto;
import org.jfjara.consumer.model.KafkaCustomValue;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class KafkaConsumerMapper {

    public KafkaCustomValue toCustomModel(final ConsumerRecord<String, String> record) {
        return KafkaCustomValue.builder()
                .key(record.key())
                .topic(record.topic())
                .value(record.value())
                .partition(String.valueOf(record.partition()))
                .build();
    }

    public List<CustomObjectReadedDto> toDto(final List<KafkaCustomValue> list) {
        return list.stream().map(v -> toDto(v)).collect(Collectors.toList());
    }

    public CustomObjectReadedDto toDto(final KafkaCustomValue kafkaCustomValue) {
        return CustomObjectReadedDto.builder()
                .key(kafkaCustomValue.getKey())
                .topic(kafkaCustomValue.getTopic())
                .value(kafkaCustomValue.getValue())
                .partition(kafkaCustomValue.getPartition()).build();
    }

}
