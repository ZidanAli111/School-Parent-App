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
