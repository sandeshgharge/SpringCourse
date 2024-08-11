package com.firstSpringBoot.restApi.DAO.SpringDataJPA;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.firstSpringBoot.restApi.model.Post;
import com.firstSpringBoot.restApi.model.User;

public interface PostSpringDataJPARepository extends JpaRepository<Post, Long>{

	public List<Post> findByUser(User u);
}
