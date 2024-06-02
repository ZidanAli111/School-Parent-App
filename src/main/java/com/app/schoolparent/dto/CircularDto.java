package com.app.schoolparent.dto;

import java.util.Date;

import com.app.schoolparent.entity.CircularDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class CircularDto {
	
	private int staffId;
    String staff;
    String informationText;
    Date notificationDate;
    String notificationPostedBy;
    String circularStatus;
    
}