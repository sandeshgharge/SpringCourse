package com.example.currency_exchange_service;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
	
	private Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);
	@Autowired 
	private Environment environment;
	
	@Autowired
	private CurrencyExchangeRepository repo;
	
	@GetMapping("currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeValue(
			@PathVariable String from,
			@PathVariable String to) {
		CurrencyExchange currencyExchange = 
				//new CurrencyExchange(1000L, from , to, BigDecimal.valueOf(50));
				this.repo.findByFromAndTo(from, to);
		if(currencyExchange == null) {
			throw new RuntimeException("Unable to find data for " + from + " and " + to);
		}
		String version = "v1";
		logger.info("Request for From : {}, To : {}", from, to);
		currencyExchange.setEnvironment(
				environment.getProperty("local.server.port") + " :: "
				+ environment.getProperty("HOSTNAME") + " :: "
				+ version + "."
				);
		return currencyExchange;
	}
}
