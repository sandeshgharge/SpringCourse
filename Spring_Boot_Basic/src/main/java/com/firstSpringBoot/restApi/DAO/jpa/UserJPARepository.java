package com.firstSpringBoot.restApi.DAO.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.firstSpringBoot.restApi.model.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository //?
@Transactional //?
public class UserJPARepository {
	
	@PersistenceContext // vs Autowired ? as both works fine
//	@Autowired
	private EntityManager entityManager;
	
	public User insert(User u) {
		return entityManager.merge(u);
	}
	
	public User findById(long id) {
		return  entityManager.find(User.class, id);
	}
	
	public void deleteById(long id) {
		User u = entityManager.find(User.class, id);
		entityManager.remove(u);
	}
	
}
