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
	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentRegisterNumber() {
		return studentRegisterNumber;
	}

	public void setStudentRegisterNumber(String studentRegisterNumber) {
		this.studentRegisterNumber = studentRegisterNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPrimaryContactPerson() {
		return primaryContactPerson;
	}

	public void setPrimaryContactPerson(String primaryContactPerson) {
		this.primaryContactPerson = primaryContactPerson;
	}

	public String getPrimaryContactPersonMobile() {
		return primaryContactPersonMobile;
	}

	public void setPrimaryContactPersonMobile(String primaryContactPersonMobile) {
		this.primaryContactPersonMobile = primaryContactPersonMobile;
	}

	public String getSecondaryContactPerson() {
		return secondaryContactPerson;
	}

	public void setSecondaryContactPerson(String secondaryContactPerson) {
		this.secondaryContactPerson = secondaryContactPerson;
	}

	public String getSecondaryContactPersonMobile() {
		return secondaryContactPersonMobile;
	}

	public void setSecondaryContactPersonMobile(String secondaryContactPersonMobile) {
		this.secondaryContactPersonMobile = secondaryContactPersonMobile;
	}

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
