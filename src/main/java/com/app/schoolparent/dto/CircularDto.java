package com.app.schoolparent.dto;

import java.util.Date;

public class CircularDto {

	private int staffId;
	String staff;
	String informationText;
	Date notificationDate;
	String notificationPostedBy;
	String circularStatus;

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

}