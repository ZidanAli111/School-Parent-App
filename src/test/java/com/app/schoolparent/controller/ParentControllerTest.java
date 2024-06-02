package com.app.schoolparent.controller;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import com.app.schoolparent.dto.ParentDto;
import com.app.schoolparent.entity.ParentDetails;
import com.app.schoolparent.service.ParentService;

public class ParentControllerTest {
	@InjectMocks
	private ParentController parentController;
	@Mock
	private ParentService parentService;
	private ParentDto parentDto;
	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
		parentDto=new ParentDto();
		parentDto.setParentId(1);
		parentDto.setParentName("Joh");
		parentDto.setStudentName("jj");
		parentDto.setAge(8);
		parentDto.setCity("gaya");
		parentDto.setAddress("mann");
		parentDto.setCountry("India");
		parentDto.setEmailAddress("adt@gmail.com");
		parentDto.setPrimaryContactPerson("paerson");
		parentDto.setPrimaryContactPersonMobile("8804873332");
		parentDto.setSecondaryContactPerson("second");
		parentDto.setSecondaryContactPersonMobile("8804873332");
	}
	@Test
	public void testSaveParent() {
//		ParentDto parentDto=new ParentDto();
//		List<ParentDto> parentList = Arrays.asList(parentDto);
//		when(parentService.getAllParents()).thenReturn(parentList);
		ResponseEntity<ParentDto>  responseEntity = parentController.saveParent(parentDto);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(parentDto, responseEntity.getBody());
		
}

}
