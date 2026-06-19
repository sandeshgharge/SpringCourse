package com.demo.kafka.producer;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import com.demo.kafka.entities.UserDetails;

@Component
public class JsonProducer {
	
	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(JsonProducer.class);
	private KafkaTemplate<String, UserDetails> kafkaTemplate;

	public JsonProducer(
			@Qualifier("userKafkaTemplate") 
			KafkaTemplate<String, UserDetails> kafkaTemplate
			) {
		
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void sendMessage(UserDetails usr) {
		LOGGER.info(usr.toString());
		
		Message<UserDetails> msg = MessageBuilder
				.withPayload(usr)
				.setHeader(KafkaHeaders.TOPIC, "javaGuides_json")
				.build();
		
		kafkaTemplate.send(msg);
		LOGGER.info(String.format("Message Sent -> %s", usr.toString()));
	}
	
}
