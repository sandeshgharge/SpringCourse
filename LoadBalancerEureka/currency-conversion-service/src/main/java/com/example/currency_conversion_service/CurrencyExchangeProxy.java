package com.example.currency_conversion_service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/*
 * This needs to be a interface and not class
 */

//@FeignClient(name="currency-exchang", url="localhost:8000")

// After Eureka Naming server is defined the url is mapped using the name attribute
// This name should be same as the sring-application name configured in the property file of Exchange Service
// Also match with the name displayed on Eureka Server

@FeignClient(name="currency-exchange-service")
public interface CurrencyExchangeProxy {

	@GetMapping("currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion retrieveExchangeValue(
			@PathVariable String from,
			@PathVariable String to);
}
