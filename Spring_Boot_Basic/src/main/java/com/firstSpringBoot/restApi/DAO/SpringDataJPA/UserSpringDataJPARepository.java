package com.firstSpringBoot.restApi.DAO.SpringDataJPA;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.firstSpringBoot.restApi.model.User;

public interface  UserSpringDataJPARepository extends JpaRepository<User, Long>{
	List<User> findByName(String name);
}
