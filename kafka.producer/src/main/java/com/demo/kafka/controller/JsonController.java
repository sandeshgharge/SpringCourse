package com.demo.kafka.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.kafka.entities.UserDetails;
import com.demo.kafka.producer.JsonProducer;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonController {

	private JsonProducer jsonProducer;

	public JsonController(JsonProducer jsonProducer) {
		this.jsonProducer = jsonProducer;
	}
	
	@PostMapping("/publish")
	public ResponseEntity<String> publishJson(@RequestBody UserDetails usr){
		jsonProducer.sendMessage(usr);
		return ResponseEntity.ok("JSON Message send to Kafka");
	}
	
	
}
