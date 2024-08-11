package com.firstSpringBoot.restApi.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import java.net.URI;
import java.util.List;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.converter.json.MappingJacksonValue;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.firstSpringBoot.restApi.DAO.UserDAOService;
import com.firstSpringBoot.restApi.exception.UserNotFoundException;
import com.firstSpringBoot.restApi.model.User;

import jakarta.validation.Valid;

// Using annotation @RestController declare the class as a controller. 
@RestController
public class UserResource {
	
	private UserDAOService service;
	
	// Public method to initialize the UserDAOService variable
	public UserResource (UserDAOService service) {
		this.service = service;
	}
	
	/**
	 * Using annotation map the method to a URL, as follows -- 
	 * @return -- List of all users
	 */
	@RequestMapping(method = RequestMethod.GET, path = "users")
	public List<User> retrieveAllUsers(){
		return service.getAllUsers();
	}
	
	/**
	 * Implementing Dynamic filter using MappingJacksonValue 
	 * @return -- List of all users
	 */
	@RequestMapping(method = RequestMethod.GET, path = "userDataFiltered")
	public MappingJacksonValue retrieveAllUsersFiltered(){
		
		MappingJacksonValue mjv = new MappingJacksonValue(service.getAllUsers());
		
		/**
		 *  Name of the entity passed that has be filtered and belongs to  the bean class
		 *  In case JSONProperty is used, string value passed should the JSONProperty value
		 */
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("user_name");
		FilterProvider filters = new SimpleFilterProvider().addFilter("All_User_Filter", filter);
		mjv.setFilters(filters );
		return mjv;
	}
	
	/**
	 *  Annotation can also be used as below using @GetMapping Annotation
	 * @param id -- Id of the user to be passed whose data has to be retrieved
	 * @return -- The object of the desired user from the list of users
	 */
	@GetMapping("user/{id}")
	public User getUser(@PathVariable Integer id) {
		
		User usrCreated = service.getUser(id);
		
		/**
		 * Exception handling for User which is not present
		 */
		if(usrCreated == null) {
			throw new UserNotFoundException("User do not exists for id : " + id);
		}
		return usrCreated;
	}
	
	
	/**
	 *  Works same as above function except he retrieving data is using the
	 *  functional programming in Java i.e. Predicate class
	 * @param id -- Id of the user to be passed whose data has to be retrieved
	 * @return -- The object of the desired user from the list of users
	 */
	@GetMapping("userFP/{id}")
	public User getUserFP(@PathVariable Integer id) {
		return service.getUserFP(id);
	}
	
	/**
	 * Hypermedia as the Engine of Application State - HATEOAS
	 * 
	 * HATEOAS is used to add links into objects that has to be returned
	 * Add spring-boot-starter-hateoas dependency in the pom.xml
	 * Use EntityModel as below
	 * 
	 * 
	 * Defined a method to get details of all the users
	 * We can give link to different as required
	 * 
	 * Check the output using API and you will get the link as defined below
	 * In this case the link is for retrieveAllUsers
	 */
	
	@GetMapping("userH/{id}")
	public EntityModel<User> getUserH(@PathVariable Integer id) {
		User user = service.getUserFP(id);
		
		EntityModel<User> em = EntityModel.of(user);
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		
		em.add(link.withRel("all-users"));
		
		return em;
	}
	
	/**
	 * Method defined to add a user, hence post mapping is used
	 * @param user -- User object to be added
	 * 
	 * @Valid used to validate user data.
	 * Works after importing spring-boot-starter-validation dependency
	 * Validations are added in the Bean file
	 */
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User usrCreated = service.save(user);
		
		// Default way to return a response
//		return ResponseEntity.created(null).build();
		
		/**
		 * Below method will take the actual custom path as we defined
		 * and the api as needed
		 */
		URI location = ServletUriComponentsBuilder
				
				/**
				 * Location will return a location value in the header that can be 
				 * clicked to view the user that has been created
				 * 
				 * Below implementation is taking the path 'users' and appending #/{id of the user}
				 * In our project it might not work as the path to check individual user starts with 
				 * 'user/{id}'. We will implement custom string uri as needed later
				 */
				
//				.fromCurrentRequest()
				
				/**
				 * Below method will take the actual custom path as we defined
				 * and the api as needed
				 * 
				 * Although we need to add entire path 'http:localhost:4002/user' to make it work
				 */
				.fromPath("/user")
				.path("/{i}")
				.buildAndExpand(usrCreated.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("user/{id}")
	public void removeUser(@PathVariable Integer id) {
		
		service.removeUser(id);
	}
}
