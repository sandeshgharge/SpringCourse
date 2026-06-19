package com.demo.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.demo.kafka.entities.UserDetails;

@Service
public class JsonConsumer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

	@KafkaListener(
		topics = "javaGuides_json",
		groupId = "group1"
	)
	public void consume(UserDetails usr) {
		LOGGER.info(String.format("JSON Message Received %d:%s", usr.getId(), usr.getName()));
	}
}
