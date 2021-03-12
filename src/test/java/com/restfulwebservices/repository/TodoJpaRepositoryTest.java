package com.restfulwebservices.repository;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.rest.webservices.restfulwebservices.domain.Todo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

//@RunWith(SpringRunner.class)
//@DataJpaTest
public class TodoJpaRepositoryTest {
	/**
	@Autowired
    private TodoJpaRepository repository;
	
	@Test
	public void findByUsername() {
				
		List<Todo> todos = repository.findByUsername("in28minutes");
		//assertThat(todos).isNotEmpty();
		
		assertNotNull(todos);
	}**/
  
}
