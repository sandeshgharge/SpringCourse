package com.example.rabbittmq.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rabbittmq.Producer.MessageProducer;
import com.example.rabbittmq.dto.UserDetails;

@RestController
@RequestMapping("api/")
public class RabbitMQController {
	
	
	private MessageProducer producer;
	
	public RabbitMQController(MessageProducer producer) {
		this.producer = producer;
	}

	@GetMapping("helloworld")
	public String helloworld() {
		return "HelloWorld";
	}

	@GetMapping("sendMessage/{str}")
	public String getNumberFromURL(@PathVariable String str) {
		this.producer.sendStringMsg(str);
		return "Check dashboard for message :"+ str;
	}
	
	@PostMapping("sendObject")
	public String getNumberFromURL(@RequestBody UserDetails usr) {
		this.producer.sendJsonMsg(usr);
		return "Check dashboard for message :"+ usr.toString();
	}
}
