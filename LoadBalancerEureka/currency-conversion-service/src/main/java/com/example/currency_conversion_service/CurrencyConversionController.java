package com.example.currency_conversion_service;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {

	/**
	 * This tedious can be replaced by the feature Spring cloud provides named FEIGN
	 */
	@Autowired
	private CurrencyExchangeProxy exchangeProxy;
	
	@GetMapping("currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurConversion(
			@PathVariable String from,
			@PathVariable String to,
			@PathVariable BigDecimal quantity
			) {
		
		HashMap<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		ResponseEntity<CurrencyConversion> respEntity = 
				new RestTemplate().getForEntity(
						"http://localhost:8000/currency-exchange/from/{from}/to/{to}",
						CurrencyConversion.class,
						uriVariables
						);
		CurrencyConversion curConv = respEntity.getBody();
		
		return new CurrencyConversion(
				curConv.getId(),
				curConv.getFrom(),
				curConv.getTo(),
				quantity,
				curConv.getConversionMultiple(),
				quantity.multiply(curConv.getConversionMultiple()),
				curConv.getEnvironment()
				);
		
		
	}
	
	/*
	 * Implementing similar functionality using FEIGN
	 * Allows us to use less number of code
	 */
	@GetMapping("currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrenyConversionFeign(
			@PathVariable String from,
			@PathVariable String to,
			@PathVariable BigDecimal quantity
			) {
		
		CurrencyConversion curConv = exchangeProxy.retrieveExchangeValue(from, to);
		return new CurrencyConversion(
				curConv.getId(),
				curConv.getFrom(),
				curConv.getTo(),
				quantity,
				curConv.getConversionMultiple(),
				quantity.multiply(curConv.getConversionMultiple()),
				curConv.getEnvironment()
				);
	}
	
}
