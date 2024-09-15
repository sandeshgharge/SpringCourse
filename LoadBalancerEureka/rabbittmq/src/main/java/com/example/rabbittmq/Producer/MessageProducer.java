package com.example.rabbittmq.Producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.rabbittmq.dto.UserDetails;

@Service
public class MessageProducer {
	
	@Value("${string.queue.key}")
	private String stringKey;
	@Value("${json.queue.key}")
	private String jsonKey;
	
	@Value("${exchange.name}")
	private String exchangeName;
	
	private RabbitTemplate rabbitTemplate;
	
	private final Logger LOGGER = LoggerFactory.getLogger(MessageProducer.class);

	public MessageProducer(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}
	
	public void sendStringMsg(String message) {
		this.rabbitTemplate.convertAndSend(exchangeName, stringKey, message);
		LOGGER.info("Message Sent : {}", message);
	}
	
	public void sendJsonMsg(UserDetails usr) {
		this.rabbitTemplate.convertAndSend(exchangeName, jsonKey, usr);
		LOGGER.info("JSON Message Sent : {}", usr.toString());
	}
}
