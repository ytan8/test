package com.restfulwebservices;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.restfulwebservices.domain.Course;
import com.restfulwebservices.domain.Registration;
import com.restfulwebservices.repository.CourseRepository;
import com.restfulwebservices.repository.RegistrationRepository;




	
	@Component
	public class MyRunner implements CommandLineRunner{
		
		//private static final Logger logger = LoggerFactory.getLogger(MyRunner.class);
		/**
		@Autowired
	    private CourseRepository courseRepository; **/
		
		@Autowired
		private RegistrationRepository registrationRepository;
		
		@Override
		public void run(String... args) throws Exception{
			
			//List<Todo> todos = todoRepository.findByUsername("in28minutes");
			
			//todos.forEach(todo -> logger.info("{}", todo));
			
			//Course course = courseRepository.findByCourseID(14326L);
			
			List<Registration> registrations = registrationRepository.getRegistration(1L);
		} 

	}


