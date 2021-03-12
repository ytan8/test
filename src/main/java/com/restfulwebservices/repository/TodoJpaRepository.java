package com.restfulwebservices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restfulwebservices.domain.Todo;


@Repository
public interface TodoJpaRepository extends JpaRepository<Todo,Long>{
	
	public List<Todo> findByUsername(String username);
	
	
}
