package org.jfjara.consumer.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class KafkaConfig {

    private static Logger logger = LoggerFactory.getLogger(KafkaConfig.class);

    @Value("${consumer.config.servers}")
    private String servers;

    @Value("${consumer.config.group-id}")
    private String groupId;

    @Bean("consumerConfig")
    public Properties producerConfig() {
        logger.info("===========> Start to configure KAFKA module infraestructure");
        Properties properties = new Properties();
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, servers);
        properties.put("group.id", groupId);
        properties.put("enable.auto.commit", "true");
        properties.put("auto.commit.interval.ms", "1000");
        properties.put("session.timeout.ms", "10000");

        logger.info("===========> End to configure KAFKA module infraestructure");

        return properties;
    }


}
