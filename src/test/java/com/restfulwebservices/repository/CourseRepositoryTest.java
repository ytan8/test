package com.restfulwebservices.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.rest.webservices.restfulwebservices.domain.Course;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CourseRepositoryTest {

	@Autowired
    private CourseRepository courseRepository;
	
	//@Test
	public void findByCourseID() {
		
		Course course = courseRepository.findByCourseID(14326L);
		assertNotNull(course);
	}
	
	@Test
	public void findAll() {
		List<Course>  courseInfo = courseRepository.findAll();
	}
	
}
