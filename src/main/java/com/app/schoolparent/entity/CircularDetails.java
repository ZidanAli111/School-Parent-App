package com.app.schoolparent.entity;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@Table
@NoArgsConstructor
public class CircularDetails {
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	public String getStaff() {
		return staff;
	}
	public void setStaff(String staff) {
		this.staff = staff;
	}
	public String getInformationText() {
		return informationText;
	}
	public void setInformationText(String informationText) {
		this.informationText = informationText;
	}
	public Date getNotificationDate() {
		return notificationDate;
	}
	public void setNotificationDate(Date notificationDate) {
		this.notificationDate = notificationDate;
	}
	public String getNotificationPostedBy() {
		return notificationPostedBy;
	}
	public void setNotificationPostedBy(String notificationPostedBy) {
		this.notificationPostedBy = notificationPostedBy;
	}
	public String getCircularStatus() {
		return circularStatus;
	}
	public void setCircularStatus(String circularStatus) {
		this.circularStatus = circularStatus;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int staffId;
	@NotNull
    String staff;
	@NotNull
    String informationText;
	@NotNull
    Date notificationDate;
	@NotNull
    String notificationPostedBy;
	@NotNull
	String circularStatus;
}
