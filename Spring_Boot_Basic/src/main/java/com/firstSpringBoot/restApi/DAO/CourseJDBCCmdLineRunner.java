package com.firstSpringBoot.restApi.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.firstSpringBoot.restApi.DAO.SpringDataJPA.CourseSpringDataJPARepository;
import com.firstSpringBoot.restApi.DAO.jdbc.CourseJDBCRepository;
import com.firstSpringBoot.restApi.DAO.jpa.CourseJPARepository;
import com.firstSpringBoot.restApi.model.Course;

/*
 * CommandLineRunner here is used to insert sample data for testing purpose
 * Same can be achieved using the Schema.sql
 */
//@Component
public class CourseJDBCCmdLineRunner implements CommandLineRunner{
	
	@Autowired
	private CourseJDBCRepository jdbcRepo;
	
	@Autowired
	private CourseJPARepository jpaRepo;
	
	@Autowired
	private CourseSpringDataJPARepository springDataJPARepo;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		/*
		 * JDBC Example
		 */
		jdbcRepo.insert();
		jdbcRepo.insert(new Course(2, "Mechatronics", "Dr. Sharbat"));
		System.out.println(jdbcRepo.fetchById(1));
		
		/*
		 * JPA Examples
		 */
		jpaRepo.insert(new Course(3, "Electronics and IT", "Dr. Marin Schram"));
		jpaRepo.insert(new Course(4, "Mechanical", "Dr. Sharbat"));
		System.out.println(jpaRepo.findById(4));
		//jpaRepo.deleteById(4);
		
		/*
		 * Spring data JPA Examples
		 * Has a lot of more features as compared to the previous versions
		 * 
		 * Define a custom methods to find the entry by name or aurthor
		 */
		
		springDataJPARepo.save(new Course(5, "International Management", "Ms. Barbara Steuer"));
		System.out.println(springDataJPARepo.findAll());
		System.out.println(springDataJPARepo.count());
		System.out.println(springDataJPARepo.findByAuthor("Dr. Sharbat"));
		springDataJPARepo.deleteById(5l);
		
	}

}
