package com.firstSpringBoot.restApi.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("user-configuration")
public class UserConfiguration {
	private String serviceName;
	private String developerName;
	
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getDeveloperName() {
		return developerName;
	}
	public void setDeveloperName(String developerName) {
		this.developerName = developerName;
	}
	
	public String getUserProperty(String str) throws Exception {
		if(str.equals("serviceName"))
			return getServiceName();
		else if (str.equals("developerName"))
			return getDeveloperName();
		else
			throw new Exception("No property found");
	}
	
}
