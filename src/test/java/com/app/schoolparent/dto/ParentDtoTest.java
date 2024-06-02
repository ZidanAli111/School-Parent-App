package com.app.schoolparent.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ParentDtoTest {

    @Test
    public void testGettersAndSetters() {
        // Arrange
        ParentDto parentDto = new ParentDto();
        int parentId = 1;
        String parentName = "John Doe";
        String studentName = "Alice Doe";
        String studentRegisterNumber = "123456";
        String address = "123 Main St";
        int age = 40;
        String state = "California";
        String country = "USA";
        String city = "Los Angeles";
        String zipCode = "90001";
        String emailAddress = "john@example.com";
        String primaryContactPerson = "Jane Doe";
        String primaryContactPersonMobile = "123-456-7890";
        String secondaryContactPerson = "Mike Doe";
        String secondaryContactPersonMobile = "987-654-3210";

        // Act
        parentDto.setParentId(parentId);
        parentDto.setParentName(parentName);
        parentDto.setStudentName(studentName);
        parentDto.setStudentRegisterNumber(studentRegisterNumber);
        parentDto.setAddress(address);
        parentDto.setAge(age);
        parentDto.setState(state);
        parentDto.setCountry(country);
        parentDto.setCity(city);
        parentDto.setZipCode(zipCode);
        parentDto.setEmailAddress(emailAddress);
        parentDto.setPrimaryContactPerson(primaryContactPerson);
        parentDto.setPrimaryContactPersonMobile(primaryContactPersonMobile);
        parentDto.setSecondaryContactPerson(secondaryContactPerson);
        parentDto.setSecondaryContactPersonMobile(secondaryContactPersonMobile);

        // Assert
        assertEquals(parentId, parentDto.getParentId());
        assertEquals(parentName, parentDto.getParentName());
        assertEquals(studentName, parentDto.getStudentName());
        assertEquals(studentRegisterNumber, parentDto.getStudentRegisterNumber());
        assertEquals(address, parentDto.getAddress());
        assertEquals(age, parentDto.getAge());
        assertEquals(state, parentDto.getState());
        assertEquals(country, parentDto.getCountry());
        assertEquals(city, parentDto.getCity());
        assertEquals(zipCode, parentDto.getZipCode());
        assertEquals(emailAddress, parentDto.getEmailAddress());
        assertEquals(primaryContactPerson, parentDto.getPrimaryContactPerson());
        assertEquals(primaryContactPersonMobile, parentDto.getPrimaryContactPersonMobile());
        assertEquals(secondaryContactPerson, parentDto.getSecondaryContactPerson());
        assertEquals(secondaryContactPersonMobile, parentDto.getSecondaryContactPersonMobile());
    }
}
