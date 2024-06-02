package com.app.schoolparent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.schoolparent.dto.CircularDto;
import com.app.schoolparent.entity.CircularDetails;
import com.app.schoolparent.repository.CircularRepository;
import com.app.schoolparent.service.CircularService;


@RestController
@RequestMapping("/api/circular")
@CrossOrigin(origins="http://localhost:4200")
public class CircularController {
	@Autowired
	private CircularService circularService;
	
	@Autowired 
	CircularRepository circularRepository;
	
	@PostMapping("/get")
	public ResponseEntity<CircularDetails> saveCircular(@RequestBody CircularDetails circularDto){
		CircularDetails savedCircular = circularService.saveCircular(circularDto);
		return ResponseEntity.ok(savedCircular);
	}
	
	@GetMapping()
	public ResponseEntity<List<CircularDetails>> getDetails(){
		return circularService.getCircular();
	}

}
