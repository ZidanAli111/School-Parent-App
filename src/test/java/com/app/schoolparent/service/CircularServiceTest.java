package com.app.schoolparent.service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.app.schoolparent.repository.CircularRepository;
import com.app.schoolparent.serviceImpl.CircularServiceImpl;
import com.app.schoolparent.entity.CircularDetails;
import org.junit.jupiter.api.Test;

@ExtendWith(MockitoExtension.class)
public class CircularServiceTest {
	@Mock  
	private CircularRepository circularRepository;
   @InjectMocks
    private CircularServiceImpl circularServiceImpl;
   private CircularDetails circularDetails;
   
   @BeforeEach
	void setUp() {
	   circularDetails=new CircularDetails();
	   circularDetails.setCircularStatus("Active");
	   circularDetails.setInformationText("tsxt");
	   circularDetails.setNotificationPostedBy("ast");
	   circularDetails.setStaff("amity");
	  // circularDetails.setNotificationDate(1-9-2024);
	}

//	@Test
//	public void saveCircularTest() {
//	CircularDetails circularDetails=circularServiceImpl.saveCircular(circularDetails);
//	
//	
//	
//		
//	}
	
   
   
}
   