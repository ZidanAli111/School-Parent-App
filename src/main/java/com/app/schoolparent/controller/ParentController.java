package com.app.schoolparent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.app.schoolparent.dto.ParentDto;
import com.app.schoolparent.entity.ParentDetails;
import com.app.schoolparent.repository.ParentRepository;
import com.app.schoolparent.service.ParentService;

@RestController
@RequestMapping("/api/parent")
@CrossOrigin(origins="http://localhost:4200")
public class ParentController {
	
	@Autowired
	private ParentService parentService;
	
	@Autowired 
	ParentRepository parentRepository;
	
	@PostMapping
	public ResponseEntity<ParentDto> saveParent(@RequestBody ParentDto parentDto){
		ParentDto savedParent = parentService.saveParent(parentDto);
		return new ResponseEntity<>(savedParent, HttpStatus.CREATED);
	}
	
	@PutMapping("/{parentId}")
	public ResponseEntity<ParentDto> updateParent(@RequestBody ParentDto parentDto, @PathVariable Integer parentId){
		ParentDto updatedParent = parentService.updateParent(parentId, parentDto);
		return new ResponseEntity<>(updatedParent, HttpStatus.OK);
	}
	@GetMapping("/{parentId}")
	public ResponseEntity<ParentDto> getDetails(@PathVariable Integer parentId){
		return ResponseEntity.ok(this.parentService.getDetails(parentId));
	}
	@GetMapping("/allParents")
	public ResponseEntity<List<ParentDto>> getAllParents(){
		return ResponseEntity.ok(parentService.getAllParents());
	}
	
}
