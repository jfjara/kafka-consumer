package org.jfjara.consumer.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class KafkaCustomValue {

    private String value;
    private String topic;
    private String partition;
    private String key;

}
