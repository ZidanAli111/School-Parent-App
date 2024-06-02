package com.app.schoolparent.entity;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ParentDetailsTest {
	@Test
	public void testGettersAndSetters() {
		ParentDetails parent = new ParentDetails();
		parent.setParentId(1);
		parent.setParentName("Akanksha");
		parent.setStudentName("joh");
		parent.setStudentRegisterNumber("R-879");
		parent.setCountry("India");
		parent.setCity("Gaya");
		parent.setAddress("Map");
		parent.setAge(7);
		parent.setPrimaryContactPerson("gracy");
		parent.setPrimaryContactPersonMobile("7867878689");
		parent.setSecondaryContactPerson("Kim");
		parent.setSecondaryContactPersonMobile("7867878689");
		parent.setEmailAddress("adt@gmail.com");
		parent.setZipCode("679878");
		

		assertEquals(1, parent.getParentId());
		assertEquals("Akanksha", parent.getParentName());
		assertEquals("joh", parent.getStudentName());
		assertEquals("R-879", parent.getStudentRegisterNumber());
		assertEquals("India", parent.getCountry());
		assertEquals("Gaya", parent.getCity());
		assertEquals("Map", parent.getAddress());
		assertEquals(7, parent.getAge());
		assertEquals("gracy", parent.getPrimaryContactPerson());
		assertEquals("7867878689", parent.getPrimaryContactPersonMobile());
		assertEquals("Kim", parent.getSecondaryContactPerson());
		assertEquals("7867878689", parent.getSecondaryContactPersonMobile());
		assertEquals("adt@gmail.com", parent.getEmailAddress());
		assertEquals("679878", parent.getZipCode());
		
		
	}

}
