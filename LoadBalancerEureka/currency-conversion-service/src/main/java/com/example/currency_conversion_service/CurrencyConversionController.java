package com.example.currency_conversion_service;

import java.math.BigDecimal;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


/**
 * Class defined to get tracing for request which are without Fiegn configuration
 * This class should be preferably defined in another method but used here as a short cut with **Micrometer**
 * 
 * 
 */
@Configuration(proxyBeanMethods = false)
class RestTemplateConfiguration {
    
    @Bean
    RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}

@RestController
public class CurrencyConversionController {
	

	private Logger logger = LoggerFactory.getLogger(CurrencyConversionController.class);

	@Autowired
	private RestTemplate restTemplate;

	/**
	 * This tedious can be replaced by the feature Spring cloud provides named FEIGN
	 * Changes are also done in the main method file
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
				// new RestTemplate().getForEntity(
				restTemplate.getForEntity(
						"http://localhost:8000/currency-exchange/from/{from}/to/{to}",
						CurrencyConversion.class,
						uriVariables
						);
		CurrencyConversion curConv = respEntity.getBody();
		logger.info("Conversion from {} and {}", from, to);

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
		
		logger.info("Conversion from {} and {}", from, to);
		
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
