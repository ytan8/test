 package com.restfulwebservices.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.restfulwebservices.domain.RegisterId;
import com.restfulwebservices.domain.Registration;
//import com.in28minutes.rest.webservices.restfulwebservices.domain.Student;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration,RegisterId>{
	
	
	//@Query("SELECT r FROM Registration r WHERE studentID = ?1")
	
	@Query("SELECT r FROM Registration r WHERE studentID = :studentId")
	public List<Registration> getRegistration(Long studentId);
	
	 Registration save(Registration registration);
	
	
     List<Registration> findByStudentId(Long studentId);
    
     Registration findByStudentIdAndCourseId(Long studentId, Long courseId);
    
     void deleteByStudentIdAndCourseId(Long studentId, Long courseId);
     
     //Registration findById(RegisterId registerId);
	

	
	 // pull courses registered by individual
	 // getCourseRegistratedByStudent


	 
	
	
}



 
