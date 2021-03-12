package com.restfulwebservices.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.restfulwebservices.domain.Course;
import com.restfulwebservices.domain.MyRegistration;
import com.restfulwebservices.domain.RegisterId;
import com.restfulwebservices.domain.Registration;
import com.restfulwebservices.domain.RegistrationInput;
import com.restfulwebservices.domain.Todo;
import com.restfulwebservices.repository.CourseRepository;
import com.restfulwebservices.repository.RegistrationRepository;
import com.restfulwebservices.repository.StudentRepository;
import com.restfulwebservices.service.CourseService;


//@CrossOrigin(origins="http://localhost:4200")
@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private RegistrationRepository registrationRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@GetMapping("/jpa/users/{username}/register")
	public List<MyRegistration> getCourseList(@PathVariable String username){
		
		List<MyRegistration> courseList = new ArrayList<MyRegistration>();
		
		courseList = courseService.getRegisteration(username);
		
		return courseList;
		
		//return null;
	}
	//create new registration
	@PostMapping("/jpa/users/{username}/register")
	public ResponseEntity<Void> createRegistration (@PathVariable String username,
			@RequestBody RegistrationInput registrationInput){
		//System.out.println("This is my input:" + registrationInput);
		//System.out.println("This is my username:" + username);
		
		//check coming date, focus is only date
		System.out.println("Target date before save:" + registrationInput.getTargetDate());
		
		//convert registration input from angular to registration object which can be saved in db
		Registration createRegistration = courseService.newRegistration(registrationInput,username);
		
		
		//check date before save, focus is only date
		
		//Todo createTodo = todoJpaRepository.save(todo);
		System.out.println("This is the new registration record: "+createRegistration);
		
		registrationRepository.save(createRegistration);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			    .path("/{id}").buildAndExpand(createRegistration.getStudentId()).toUri();
		
		return  ResponseEntity.created(uri).build();
		
	}
	
	//updateRegistration
	@PutMapping("/jpa/users/{username}/register/{courseName}")
	public ResponseEntity<Registration> updateRegistration(@PathVariable String username, 
			 @RequestBody RegistrationInput registrationInput){
		
		
		
		Registration registUpdate = registrationRepository.save(courseService.updateRegistration(username, registrationInput));
		
		return new ResponseEntity<Registration>(HttpStatus.OK);
	}
	
	/**
	  @DeleteMapping("/jpa/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(
			@PathVariable String username, @PathVariable long id){
		todoJpaRepository.deleteById(id);
		
		
		return ResponseEntity.notFound().build();
	}
	 */
	
	@DeleteMapping("/jpa/users/{username}/register/{courseName}")
	public ResponseEntity<Void> deleteRegistration(@PathVariable String username, 
			@PathVariable String courseName){
		
		System.out.println("before delete method");
		
		Long studentID = studentRepository.findByName(username).getStudentID();
		Long courseID = courseRepository.findByName(courseName).getCourseID();
		
		System.out.println("studentID == " + studentID);
		System.out.println("courseID == " + courseID);
		
		RegisterId registerId = new RegisterId(courseID, studentID);
		
		registrationRepository.deleteById(registerId);
		
		//registrationRepository.find
		
		
		//registrationRepository.deleteByStudentIdAndCourseId((studentRepository.findByName(username)).getStudentID(),(courseRepository.findByName(courseName)).getCourseID());		
		System.out.println("after delete method");
	
		return ResponseEntity.noContent().build();
	}
	
	//get the list of course information
	@GetMapping("/jpa/users/{username}/register/new")
	public List<String> getCourseName(@PathVariable String username){
		
		List<String> courseName = new ArrayList<String>();
		
		courseName = courseService.getCourseName();
		
		//return null;
		
		return courseName;
	}
	
	@GetMapping("/jpa/users/{username}/register/{courseName}")
	public MyRegistration getCourseByCourseID(@PathVariable String username, 
			@PathVariable String courseName) {
		
		Long studentID = studentRepository.findByName(username).getStudentID();
		Long courseID = courseRepository.findByName(courseName).getCourseID();
		
		
		
		RegisterId registerId = new RegisterId(courseID, studentID);
		
		Optional<Registration> registration = Optional.empty();
		registration = registrationRepository.findById(registerId);
		//Registration registrationTemp = registrationRepository.findById(registerId);
		
		MyRegistration myReg = new MyRegistration();
		myReg.setCourseName(courseName);
		myReg.setRegisterDate(registration.get().getRegisterDate());
		myReg.setTargetDate(registration.get().getTargetDate());					  
		myReg.setStatus( registration.get().getStatus());
		
		System.out.println(myReg);
		
		return myReg;
	}
	
	/**
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/jpa/users/{username}/courseList")
	public List<MyCourse> getCourseList(@PathVariable String username){
		
		List<MyCourse> courseList = new ArrayList<MyCourse>();
		
		courseList = courseService.getCourses(username);
		
		return courseList;
	
		
		//return null;
	}
	
	**/

}
