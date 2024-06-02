package com.app.schoolparent.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.app.schoolparent.entity.CircularDetails;
import com.app.schoolparent.repository.CircularRepository;

@ExtendWith(MockitoExtension.class)
public class CircularServiceImplTest {

    @Mock
    private CircularRepository circularRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private CircularServiceImpl circularService;

   

    @Test
    void testSaveCircular() {
        // Arrange
        CircularDetails circularDetails = new CircularDetails();
        // Set properties of circularDetails
        
        when(modelMapper.map(any(CircularDetails.class), eq(CircularDetails.class))).thenReturn(circularDetails);
        when(circularRepository.save(any(CircularDetails.class))).thenReturn(circularDetails);

        // Act
        CircularDetails response = circularService.saveCircular(circularDetails);

        // Assert
        assertNotNull(response);
        // Add more assertions as needed to verify the behavior of the method
    }


     

  
    
    @Test
    void testGetCircular() {
        // Arrange
        List<CircularDetails> circularDetailsList = new ArrayList<>();
        // Add some circular details to the list

        when(circularRepository.findAll()).thenReturn(circularDetailsList);

        // Act
        ResponseEntity<List<CircularDetails>> responseEntity = circularService.getCircular();

        // Assert
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(circularDetailsList, responseEntity.getBody());
    }

    @Test
    void testGetCircular_Exception() {
        // Arrange
        when(circularRepository.findAll()).thenThrow(new RuntimeException("Error fetching circular details"));

        // Act
        ResponseEntity<List<CircularDetails>> responseEntity = circularService.getCircular();

        // Assert
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals(0, responseEntity.getBody().size());
    }


}
