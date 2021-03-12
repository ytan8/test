package com.restfulwebservices.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.rest.webservices.restfulwebservices.domain.Registration;



@RunWith(SpringRunner.class)
@DataJpaTest
public class RegistrationRepositoryTest {
	
	@Autowired
    private RegistrationRepository registerationRepository;
		
	 @Test
	public void test() {

		// registerationRepository.findByStudentId(1L);

		List<Registration> registerations = registerationRepository.getRegistration(1L);
		
		Registration registration = registerationRepository.findByStudentIdAndCourseId(1L, 14326L);
		
		registerationRepository.deleteByStudentIdAndCourseId(1L, 14326L);

	}


	
	
	

}
