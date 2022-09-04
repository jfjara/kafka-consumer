package org.jfjara.consumer.ports;

import org.jfjara.consumer.dto.CustomObjectReadedDto;

import java.util.List;

public interface ConsumerRepository {

    void init(final String topic);
    List<CustomObjectReadedDto> consume();

}
