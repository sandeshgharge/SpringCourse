package com.firstSpringBoot.restApi.helloworld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	/*
	 *	Used during internationalising messages 
	 */
	private MessageSource msg;
	
	public HelloWorldController(MessageSource msg) {
		this.msg = msg;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "hellowrld")
	public String helloWorld() {
		return "Hello World..!";
	}
	
	@GetMapping(path = "helloworld")
	public String helloWorldGetMapping() {
		return "Hello World using GetMapping";
	}
	
	@GetMapping(path="returnObj")
	public Message returnObj() {
		return new Message("Welcome to REST Api");
	}
	
	@GetMapping(path="returnStrObj")
	public String returnStrObj() {
		return new Message("Welcome to REST Api").toString();
	}
	
	@GetMapping(path = "pathVariable/{name}")
	public String pathVariableName(@PathVariable String name) {
		return "Hello " + name;
	}
	
	/**
	 * Values to be returned can be processed in multiple languages
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, path = "hellowrldI18n")
	public String helloWorldI18n() {
		
		/**
		 * To add support for multiple languages follow below steps
		 * 
		 * 1. Add message.properties, message_de.properties or more files as per requirement of multiple languages under resource folder
		 * 2. Use below Locale to get the required data from *.properties file
		 * 3. In the request use the header entity as "Accept-Language : de". Add the language as per requirement
		 * 
		 */
		Locale locale = LocaleContextHolder.getLocale();
		return msg.getMessage("good.morning.message", null, "Default Message", locale);
	}
}

class Message{
	private String msg;

	public Message(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "Message [msg=" + msg + "]";
	}
	
	
	
}