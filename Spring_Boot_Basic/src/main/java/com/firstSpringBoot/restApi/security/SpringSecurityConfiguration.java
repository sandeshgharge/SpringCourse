package com.firstSpringBoot.restApi.security;

import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * In case this security file a filter chain is defined which will take care of the security
 * If not defined the default login page is displayed to access the data using user and password
 */
//@Configuration
public class SpringSecurityConfiguration {

//	@Besan 
	public SecurityFilterChain filterChain(HttpSecurity httpS) throws Exception {
		
		// 1. All requests should be authenticated
		httpS.authorizeHttpRequests(
				auth -> auth.anyRequest().authenticated()
				);
		// 2. If a request is not authenticated, a web page is shown for login, below part will replace with a pop up
		
		httpS.httpBasic(withDefaults());
		// 3. CSRF --> POST, PUT
		httpS.csrf().disable();
		return httpS.build();
	}
}
