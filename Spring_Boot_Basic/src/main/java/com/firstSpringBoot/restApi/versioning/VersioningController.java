package com.firstSpringBoot.restApi.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Versioning can be done in multiple ways : 
 * 1. URL
 * 	- getVersion1
 * 	- getVersion2
 * 
	 * Advantages : 
	 * 	a. Use of HTTP Headers
	 * 	b. Caching possible as it depends only on URL
	 * 	c. Browser Executable
	 * 	d. Distinct API Documentation possible
	 * 
	 * Disadvantages : 
	 * 	a. URI Pollution
 * 
 * 2. Request Parameter - Amazon
 * 	- getVersionUsingRequestParameter1 - URL to use http://localhost:4002/person?version=1
 * 	- getVersionUsingRequestParameter2 - URL to use http://localhost:4002/person?version=2
 * 
 * 3. Header - Microsoft
 * 	- getVersionUsingHeader1 - Use Header Parameter as X-API-VERSION : 1
 * 	- getVersionUsingHeader2 - Use Header Parameter as X-API-VERSION : 2
 * 
	 * Advantages : 
	 * 	a. No URI Pollution
	 * 
	 * Disadvantages : 
	 * 	a. Use of HTTP Headers
	 * 	b. Caching not possible as it depends only on URL
	 * 	c. Not Browser Executable
	 * 	d. Distinct API Documentation might not be possible
 * 
 * 4. Media Type - GitHub
 * 	- getVersionUsingMedia1 - Accept : application/vnd.company.app-v1+json
 * 	- getVersionUsingMedia2 - Accept : application/vnd.company.app-v2+json
 * 
	 * Advantages : 
	 * 	a. No URI Pollution
	 * 
	 * Disadvantages : 
	 * 	a. Use of HTTP Headers
	 * 	b. Caching not possible as it depends only on URL
	 * 	c. Not Browser Executable
	 * 	d. Distinct API Documentation might not be possible
 * 
 * So depending upon the scenarios this versioning is used
 */

@RestController
public class VersioningController {

	@GetMapping("/v1/person")
	public PersonV1 getVersion1() {
		
		return new PersonV1("Sandy");
	}
	
	@GetMapping("/v2/person")
	public PersonV2 getVersion2() {
		return new PersonV2("Sandy", "G");
	}
	
	@GetMapping(path = "/person", params = "version=1")
	public PersonV1 getVersionUsingRequestParameter1() {
		
		return new PersonV1("Sandy");
	}
	
	@GetMapping(path = "/person", params = "version=2")
	public PersonV2 getVersionUsingRequestParameter2() {
		return new PersonV2("Sandy", "G");
	}
	
	@GetMapping(path = "/person", headers = "X-API-VERSION=1")
	public PersonV1 getVersionUsingHeader1() {
		return new PersonV1("Sandy");
	}
	
	@GetMapping(path = "/person", headers = "X-API-VERSION=2")
	public PersonV2 getVersionUsingHeader2() {
		return new PersonV2("Sandy", "G");
	}
	
	@GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v1+json")
	public PersonV1 getVersionUsingMedia1() {
		return new PersonV1("Sandy");
	}
	
	@GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v2+json")
	public PersonV2 getVersionUsingMedia2() {
		return new PersonV2("Sandy", "G");
	}
}

class PersonV1{
	public PersonV1(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String name;
	
}

class PersonV2{

	private String firstName;
	private String lastName;
	public PersonV2(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}
