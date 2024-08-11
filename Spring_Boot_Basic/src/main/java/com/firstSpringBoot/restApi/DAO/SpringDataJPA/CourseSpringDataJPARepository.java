package com.firstSpringBoot.restApi.DAO.SpringDataJPA;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.firstSpringBoot.restApi.model.Course;

public interface  CourseSpringDataJPARepository extends JpaRepository<Course, Long>{

	/*
	 * Custom methods to fetch values using different column names
	 * Make sure the method has a proper naming structure
	 * 
	 * Here findBy... is followed by the entity name i.e. ... Author
	 * findByAuthor
	 */
	List<Course> findByAuthor(String author);
}
