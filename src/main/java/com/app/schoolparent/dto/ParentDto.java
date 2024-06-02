package com.app.schoolparent.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParentDto {
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
 
	int parentId;
	private String parentName;
	private String studentName;
 
    private String studentRegisterNumber;
	private String address;
 
	private int age;
    private String state;
	private String country;
	private String city;

	private String zipCode;
	private String emailAddress;
	private String primaryContactPerson;
	private String primaryContactPersonMobile;
	private String secondaryContactPerson;
	private String secondaryContactPersonMobile;
	//	@Id
	//	@Column
	//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//	private int registrationId;
}

