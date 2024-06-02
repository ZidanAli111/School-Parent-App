package com.app.schoolparent.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.junit.jupiter.api.BeforeEach;

import com.app.schoolparent.entity.ParentDetails;

@DataJpaTest
public class ParentRepositoryTest {
	@Autowired
	private ParentRepository parentRepository;
	private ParentDetails parentDetails;
	@BeforeEach
	void set()
	{
		parentDetails=new ParentDetails();
		parentDetails.setParentId(1);
		parentDetails.setParentName("Joh");
		parentDetails.setStudentName("jj");
		parentDetails.setAge(8);
		parentDetails.setCity("gaya");
		parentDetails.setAddress("mann");
		parentDetails.setCountry("India");
		parentDetails.setEmailAddress("adt@gmail.com");
		parentDetails.setPrimaryContactPerson("paerson");
		parentDetails.setPrimaryContactPersonMobile("8804873332");
		parentDetails.setSecondaryContactPerson("second");
		parentDetails.setSecondaryContactPersonMobile("8804873332");
		
		
	}
	@Test	
	public void testSave() {
		
		parentRepository.save(parentDetails);
		
		ParentDetails existingParent=parentRepository.findById(1).orElse(null);
		assertThat(existingParent).isNotNull();
	}
}
