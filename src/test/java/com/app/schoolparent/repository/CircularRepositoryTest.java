package com.app.schoolparent.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.app.schoolparent.entity.CircularDetails;

@DataJpaTest
public class CircularRepositoryTest {
	@Autowired
	private CircularRepository circularRepository;
	
	CircularDetails circularDetails=new CircularDetails();
	

}
