package org.jfjara.consumer.config;

import org.jfjara.consumer.repository.KafkaConsumerRepository;
import org.jfjara.consumer.usecase.ReadMessagesUseCase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public ReadMessagesUseCase readMessagesUseCase(final KafkaConsumerRepository kafkaConsumerRepository,
                                                   @Value("${consumer.config.topic}") final String topic) {
        return new ReadMessagesUseCase(kafkaConsumerRepository, topic);
    }

}
