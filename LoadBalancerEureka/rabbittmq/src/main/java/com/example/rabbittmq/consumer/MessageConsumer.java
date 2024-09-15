package com.example.rabbittmq.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.example.rabbittmq.Producer.MessageProducer;

@Service
public class MessageConsumer {
	
	private final Logger LOGGER = LoggerFactory.getLogger(MessageConsumer.class);

	
	@RabbitListener(queues = {"${string.queue.name}"})
	public void consumeString(String msg) {
		LOGGER.info("Received String Message : {}", msg);
	}
	
	@RabbitListener(queues = {"${json.queue.name}"})
	public void consumeJson(String msg) {
		LOGGER.info("Received Json Message : {}", msg);
	}
}
