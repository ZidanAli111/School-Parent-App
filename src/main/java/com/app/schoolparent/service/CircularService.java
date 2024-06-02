package com.app.schoolparent.service;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.app.schoolparent.dto.CircularDto;
import com.app.schoolparent.entity.CircularDetails;

public interface CircularService {
	CircularDetails saveCircular(CircularDetails circularDto);
	ResponseEntity<List<CircularDetails>> getCircular();

}


