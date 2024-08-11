package com.firstSpringBoot.restApi.DAO.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.firstSpringBoot.restApi.model.Course;

@Repository
public class CourseJDBCRepository {
	
	@Autowired
	private JdbcTemplate springJdbcTemplate;
	private static String INSERT_QUERY_FIXED = """
			
			insert into Course (ID, NAME, AUTHOR) values (1, 'Computer Science', 'Dr. Faber Peter');
			
			""";
	private static String INSERT_QUERY = """
			
			insert into Course (ID, NAME, AUTHOR) values (?, ?, ?);
			
			""";
	private static String SELECT_QUERY = """
			
			select * from course where id = ?
			""";
	
	public void insert() {
		springJdbcTemplate.update(INSERT_QUERY_FIXED);
	}
	
	public void insert(Course course) {
		springJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
	}
	
	public Course fetchById(long id) {
		
		/*
		 * BeanPropertyRowMapper is used if the bean member variables matches the columns of the table
		 */
		return springJdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
	}
}
