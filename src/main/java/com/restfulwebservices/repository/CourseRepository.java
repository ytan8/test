package com.restfulwebservices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.restfulwebservices.domain.Course;
import com.restfulwebservices.domain.Registration;


@Repository
public interface CourseRepository extends JpaRepository<Course,Long>{

	//List<Course> findByStudentID(Long studentID);
	
	Course findByCourseID(Long courseId);
	
	Course findByName(String name);
		

	List<Course> findAll();
	
	
}
