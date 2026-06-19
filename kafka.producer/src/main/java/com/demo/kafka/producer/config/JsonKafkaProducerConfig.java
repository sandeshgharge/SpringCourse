package com.demo.kafka.producer.config;

import java.util.Map;
import java.util.HashMap;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.demo.kafka.entities.UserDetails;

@Configuration
public class JsonKafkaProducerConfig {

    @Bean
    public ProducerFactory<String, UserDetails> userProducerFactory() {

        Map<String, Object> props = new HashMap<String, Object>();

        props.put(
                ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                "localhost:9092");

        props.put(
                ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class);

        props.put(
                ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                JsonSerializer.class);

        return new DefaultKafkaProducerFactory<String, UserDetails>(props);
    }

    @Bean("userKafkaTemplate")
    public KafkaTemplate<String, UserDetails> userKafkaTemplate() {
        return new KafkaTemplate<>(userProducerFactory());
    }
}