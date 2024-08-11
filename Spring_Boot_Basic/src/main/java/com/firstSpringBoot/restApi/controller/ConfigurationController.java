package com.firstSpringBoot.restApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.firstSpringBoot.restApi.configuration.UserConfiguration;

@RestController
public class ConfigurationController {
	
	@Autowired
	private UserConfiguration config;

	@GetMapping("configuration/{var}")
	public Object getConfigurationProperty(@PathVariable String var) throws Exception {
		return this.config.getUserProperty(var);
	}
}
