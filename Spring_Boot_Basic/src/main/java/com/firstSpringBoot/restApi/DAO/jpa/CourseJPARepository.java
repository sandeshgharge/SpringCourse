package com.firstSpringBoot.restApi.DAO.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.firstSpringBoot.restApi.model.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository //?
@Transactional //?
public class CourseJPARepository {
	
	@PersistenceContext // vs Autowired ? as both works fine
//	@Autowired
	private EntityManager entityManager;
	
	public void insert(Course c) {
		entityManager.merge(c);
	}
	
	public Course findById(long id) {
		return  entityManager.find(Course.class, id);
	}
	
	public void deleteById(long id) {
		Course c = entityManager.find(Course.class, id);
		entityManager.remove(c);
	}
	
}
