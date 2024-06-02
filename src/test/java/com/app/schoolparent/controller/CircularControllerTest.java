package com.app.schoolparent.controller;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.app.schoolparent.entity.CircularDetails;
import com.app.schoolparent.service.CircularService;

public class CircularControllerTest {

    @Mock
    private CircularService circularService;

    @InjectMocks
    private CircularController circularController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveCircular() {
        // Arrange
        CircularDetails circularDto = new CircularDetails();
        CircularDetails savedCircular = new CircularDetails();
        when(circularService.saveCircular(any(CircularDetails.class))).thenReturn(savedCircular);

        // Act
        ResponseEntity<CircularDetails> response = circularController.saveCircular(circularDto);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(savedCircular, response.getBody());
    }

    @Test
    void testGetDetails() {
        // Arrange
        List<CircularDetails> circularList = Arrays.asList(new CircularDetails(), new CircularDetails());
        when(circularService.getCircular()).thenReturn(new ResponseEntity<>(circularList, HttpStatus.OK));

        // Act
        ResponseEntity<List<CircularDetails>> response = circularController.getDetails();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(circularList, response.getBody());
    }
}
