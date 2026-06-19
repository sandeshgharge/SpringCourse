package com.demo.kafka.producer;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
	
	private static final org.slf4j.Logger Logger = LoggerFactory.getLogger(KafkaProducer.class);
	private KafkaTemplate<String, String> kafkaTemplate;

	public KafkaProducer(
			@Qualifier("stringKafkaTemplate")
			KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void sendMessage(String msg) {
		Logger.info(String.format("Message sent %s", msg));
		kafkaTemplate.send("javaGuides", msg);
	}
	
}
