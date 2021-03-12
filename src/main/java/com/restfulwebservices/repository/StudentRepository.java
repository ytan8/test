package com.restfulwebservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restfulwebservices.domain.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long>{
	
	Student findByName(String name);

}
