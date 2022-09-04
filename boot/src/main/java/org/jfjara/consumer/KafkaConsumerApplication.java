package org.jfjara.consumer;

import org.jfjara.consumer.dto.CustomObjectReadedDto;
import org.jfjara.consumer.usecase.ReadMessagesUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.List;

@SpringBootApplication
public class KafkaConsumerApplication {

    @Autowired
    private ReadMessagesUseCase readMessagesUseCase;

    public static void main(String[] args) {
        SpringApplication.run(KafkaConsumerApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void runAfterStartup() {
        while (true) {
            List<CustomObjectReadedDto> result = readMessagesUseCase.execute();
            result.forEach(r -> System.out.println(r));
        }
    }
}
