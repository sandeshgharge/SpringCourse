package com.firstSpringBoot.restApi.DAO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import com.firstSpringBoot.restApi.model.User;

@Component
public class UserDAOService {
	
	private static List<User> users = new ArrayList<>();
	private static int usersCount = 0;
	
	static {
		
		users.add(new User(++usersCount, "Sandesh", LocalDate.now().minusYears(28)));
		users.add(new User(++usersCount, "Sandy", LocalDate.now().minusYears(25)));
		users.add(new User(++usersCount, "Bunty", LocalDate.now().minusYears(24)));
	}
	
	public List<User> getAllUsers(){
		return users;
	}
	
	public User getUser(Integer id) {
		User res = null;
		for(User user : users) {
			if(user.getId() == id)
				res = user;
		}
		return res;
	}
	
	// You can introduce functional programming in JAVA as below
	public User getUserFP(Integer id) {
		
		Predicate <? super User> predicate = user -> user.getId().equals(id);
		return users.stream().filter(predicate).findAny()
				/**
				 * In case there is no element as required this method would return NoSuchElementException
				 */
//				.get();
				
				/**
				 * Below method can be used to tackle such scenarios by returning a null user or pass a default User
				 */
				.orElse(null);
	}
	
	public User save (User user) {
		user.setId(++usersCount);
		users.add(user);
		return user;
	}

	public void removeUser(Integer id) {
		// TODO Auto-generated method stub
		Predicate <? super User> predicate = user -> user.getId().equals(id);
		
		// removeIf accepts only predicate object for object removal
		users.removeIf(predicate);
	}
}
