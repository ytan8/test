package com.restfulwebservices.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.joda.time.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.restfulwebservices.domain.Course;
import com.restfulwebservices.domain.MyRegistration;
import com.restfulwebservices.domain.Registration;
import com.restfulwebservices.domain.RegistrationInput;
import com.restfulwebservices.domain.Student;
import com.restfulwebservices.domain.Todo;
import com.restfulwebservices.repository.CourseRepository;
import com.restfulwebservices.repository.RegistrationRepository;
import com.restfulwebservices.repository.StudentRepository;


@Service
public class CourseService {
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	RegistrationRepository registrationRepository;
	
	private static long idCounter = 0;
	private static List<Registration> registrations = new ArrayList<>();
	//private static List<Todo> todos = new ArrayList<>();
	
	public List<MyRegistration> getRegisteration(String username){
	
		Student std = studentRepository.findByName(username);
		List<Registration> registrations = registrationRepository.findByStudentId(std.getStudentID());
		//Course course = courseRepository.findByCourseID(registeration.get());
		
		List<MyRegistration> myRegList = new ArrayList<MyRegistration>();
		

		for(int i = 0; i< registrations.size();i++) {
			MyRegistration myReg = new MyRegistration((courseRepository.findByCourseID(registrations.get(i).getCourseId())).getName(), 
											registrations.get(i).getRegisterDate(),
											 registrations.get(i).getTargetDate(), 
											 registrations.get(i).getStatus());
			
			myRegList.add(myReg);
		}
		
		return myRegList;
	}
	
	
	public Registration newRegistration(RegistrationInput registrationInput, String username){
		
		Registration registration = new Registration();
		
		
		registration.setStudentId((studentRepository.findByName(username).getStudentID()));
		registration.setCourseId(courseRepository.findByName(registrationInput.getCourseName()).getCourseID());
		registration.setSemeter(courseRepository.findByName(registrationInput.getCourseName()).getAvailableSemster());
		registration.setStatues("false");
		registration.setRegisterDate(new Date());
		//registration.setRegisterDate(registrationInput.getRegisterDate());
		registration.setTargetDate(registrationInput.getTargetDate());
		
		System.out.println(registration);
		
		return registration;
		
	}
	
		
	public Registration updateRegistration(String username, RegistrationInput registrationInput) {
		
		Registration registration = new Registration();
		
		Student std = studentRepository.findByName(username);
		Course course = courseRepository.findByName(registrationInput.getCourseName());
		
        registration = registrationRepository.findByStudentIdAndCourseId(std.getStudentID(), course.getCourseID());
        
        registration.setTargetDate(registrationInput.getTargetDate());
		
		return registration;
		
	}
	
	public List<String> getCourseName() {
		
		List<Course> courses = courseRepository.findAll();
		
		List<String> courseNames = new ArrayList<String>();
		
		String courseName;
		
		for(int i = 0; i< courses.size();i++) {
			
					 courseName = courses.get(i).getName();
					 courseNames.add(courseName);		
		}
		
		return courseNames;
	}

	
	
	//pull id by name
	// pull course by id
	// set values to MyCourse and return List
	/**
	public List<MyCourse> getCourses(String username) {
		
		
		Student std = studentRepository.findByName(username);
		
		
		List<Course> courses = courseRepository.findByStudentID(std.getStudentId());
		
		
		List<MyCourse> mycoursesList = new ArrayList<MyCourse>();
		
		for(int i = 0; i< courses.size();i++) {
			MyCourse mycourse = new MyCourse(courses.get(i).getCourseID(), 
											 "in28minutes", 
											 courses.get(i).getName());
											 courses.get(i).getCompletedate());
			
			mycoursesList.add(mycourse);
		}
		
		return mycoursesList;
		
		
		
		
	}

**/

}
