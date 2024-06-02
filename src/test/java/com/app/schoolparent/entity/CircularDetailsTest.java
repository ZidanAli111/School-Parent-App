package com.app.schoolparent.entity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CircularDetailsTest {
	@Test
	public void testGettersAndSetters() {
		CircularDetails circular = new CircularDetails();
		circular.setStaff("Sanskar");
		circular.setNotificationPostedBy("sanju");
		circular.setCircularStatus("yes");
		circular.setInformationText("information");
		
		assertEquals("Sanskar",circular.getStaff());
	    assertEquals("sanju",circular.getNotificationPostedBy());
	    assertEquals("yes",circular.getCircularStatus());
	    assertEquals("information",circular.getInformationText());
		}
	

}
