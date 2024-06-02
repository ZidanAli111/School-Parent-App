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
	
}

