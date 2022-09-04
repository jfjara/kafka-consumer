package org.jfjara.consumer.usecase;

import org.jfjara.consumer.dto.CustomObjectReadedDto;
import org.jfjara.consumer.ports.ConsumerRepository;

import java.util.List;

public class ReadMessagesUseCase {

    private final ConsumerRepository consumerRepository;

    private final String topic;


    public ReadMessagesUseCase(final ConsumerRepository consumerRepository, final String topic) {
        this.consumerRepository = consumerRepository;
        this.topic = topic;
        consumerRepository.init(topic);
    }

    public List<CustomObjectReadedDto> execute() {
        return consumerRepository.consume();
    }
}
