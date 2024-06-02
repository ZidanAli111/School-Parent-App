package com.app.schoolparent.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;

public class CircularDtoTest {

    @Test
    public void testGettersAndSetters() {
        // Arrange
        CircularDto circularDto = new CircularDto();
        int staffId = 123;
        String staff = "Staff Name";
        String informationText = "Important information";
        Date notificationDate = new Date();
        String notificationPostedBy = "Admin";
        String circularStatus = "Active";

        // Act
        circularDto.setStaffId(staffId);
        circularDto.setStaff(staff);
        circularDto.setInformationText(informationText);
        circularDto.setNotificationDate(notificationDate);
        circularDto.setNotificationPostedBy(notificationPostedBy);
        circularDto.setCircularStatus(circularStatus);

        // Assert
        assertEquals(staffId, circularDto.getStaffId());
        assertEquals(staff, circularDto.getStaff());
        assertEquals(informationText, circularDto.getInformationText());
        assertEquals(notificationDate, circularDto.getNotificationDate());
        assertEquals(notificationPostedBy, circularDto.getNotificationPostedBy());
        assertEquals(circularStatus, circularDto.getCircularStatus());
    }
}
