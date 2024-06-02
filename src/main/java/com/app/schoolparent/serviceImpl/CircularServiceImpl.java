package com.app.schoolparent.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.schoolparent.entity.CircularDetails;
import com.app.schoolparent.repository.CircularRepository;
import com.app.schoolparent.service.CircularService;

@Service
public class CircularServiceImpl implements CircularService {

	@Autowired
	private CircularRepository circularRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CircularDetails saveCircular(CircularDetails circularDto) {
		CircularDetails circularDetails = modelMapper.map(circularDto, CircularDetails.class);
		CircularDetails savedCircular = circularRepository.save(circularDetails);
		return modelMapper.map(savedCircular, CircularDetails.class);
	}

	@Override
	public ResponseEntity<List<CircularDetails>> getCircular() {
		try {
			return new ResponseEntity<>(circularRepository.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}
	
	
}
