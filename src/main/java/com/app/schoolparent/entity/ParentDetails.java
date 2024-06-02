package com.app.schoolparent.entity;

import java.util.Random;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@Table
@NoArgsConstructor
public class ParentDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int parentId;

	
	@NotNull
	@Pattern(regexp="^[a-zA-Z\s]+$",message="Name must contain only alphabets and spaces")
	private String parentName;
	
	@NotNull
	@Pattern(regexp="^[a-zA-Z\s]+$",message="Name must contain only alphabets and spaces")
	private String studentName;

//	public ParentDetails() {
//		this.registrationId = generateRegistrationId();
//		System.out.println("registrationId"+this.registrationId);
//	}
//	
//	private Long generateRegistrationId() {
//		Random random = new Random();
//		return random.nextLong()%9000000000L+1000000000L;
//	}
//
//	@Column
//	private Long registrationId;
	
	@Pattern(regexp="^R-\\d{3}$",message="Student Registration Number should be in 'R-XXX' ")
    private String studentRegisterNumber;
	
	@NotNull
	private String address;
	
	@NotNull
	@Min(value=4)
	private int age;
	
	@NotNull
    private String state;
	
	@NotNull
	private String country;
	
	@NotNull
	@Pattern(regexp="^[a-zA-Z]+$",message="Name must contain only alphabets")
	private String city;
	
	@NotNull
	@Pattern(regexp = "^\\d{6}$")
	private String zipCode;
	
	@NotNull
	@Email
	private String emailAddress;
	
	@NotNull
	private String primaryContactPerson;
	
	@NotNull
	@Pattern(regexp = "^\\d{10}$")
	private String primaryContactPersonMobile;
	
	@NotNull
	private String secondaryContactPerson;
	
	@NotNull
	@Pattern(regexp = "^\\d{10}$")
	private String secondaryContactPersonMobile;
	
}
