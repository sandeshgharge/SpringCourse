package com.example.rabbittmq.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

	@Value("${string.queue.name}")
	private String queueNameString;
	@Value("${json.queue.name}")
	private String queueNameJson;
	
	@Value("${string.queue.key}")
	private String stringKey;
	@Value("${json.queue.key}")
	private String jsonKey;
	
	@Value("${exchange.name}")
	private String exchangeName;
	
	@Bean
	public Queue stringQueue() {
		return new Queue(queueNameString);
	}
	
	@Bean
	public Queue jsonQueue() {
		return new Queue(queueNameJson);
	}
	
	@Bean
	public TopicExchange exchange() {
		return new TopicExchange(exchangeName);
	}
	
	@Bean
	public Binding bindStringQueue() {
		return BindingBuilder
				.bind(stringQueue())
				.to(exchange())
				.with(stringKey);
	}
	
	@Bean
	public Binding bindJsonQueue() {
		return BindingBuilder
				.bind(jsonQueue())
				.to(exchange())
				.with(jsonKey);
	}
	
	@Bean
	public MessageConverter converter() {
		return new Jackson2JsonMessageConverter();
	}
	
	@Bean
	public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(converter());
		return rabbitTemplate;
	}
	
	/**
	 * Below beans are auto-configured
	 * 
	 * 1. ConnectionFactory
	 * 2. RabbitTemplate
	 * 3. RabbitAdmin
	 */
}