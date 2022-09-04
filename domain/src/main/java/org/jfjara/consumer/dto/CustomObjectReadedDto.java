package org.jfjara.consumer.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder(toBuilder = true)
@ToString
public class CustomObjectReadedDto {

    private String value;
    private String topic;
    private String partition;
    private String key;
}
