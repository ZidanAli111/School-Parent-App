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

import com.app.schoolparent.dto.ParentDto;
import com.app.schoolparent.service.ParentService;

public class ParentControllerTest {

    @Mock
    private ParentService parentService;

    @InjectMocks
    private ParentController parentController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveParent() {
        // Arrange
        ParentDto parentDto = new ParentDto();
        ParentDto savedParent = new ParentDto();
        when(parentService.saveParent(any(ParentDto.class))).thenReturn(savedParent);

        // Act
        ResponseEntity<ParentDto> response = parentController.saveParent(parentDto);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(savedParent, response.getBody());
    }

    @Test
    void testUpdateParent() {
        // Arrange
        int parentId = 1;
        ParentDto parentDto = new ParentDto();
        ParentDto updatedParent = new ParentDto();
        when(parentService.updateParent(eq(parentId), any(ParentDto.class))).thenReturn(updatedParent);

        // Act
        ResponseEntity<ParentDto> response = parentController.updateParent(parentDto, parentId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedParent, response.getBody());
    }

    @Test
    void testGetDetails() {
        // Arrange
        int parentId = 1;
        ParentDto parentDto = new ParentDto();
        when(parentService.getDetails(parentId)).thenReturn(parentDto);

        // Act
        ResponseEntity<ParentDto> response = parentController.getDetails(parentId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(parentDto, response.getBody());
    }

    @Test
    void testGetAllParents() {
        // Arrange
        List<ParentDto> parentList = Arrays.asList(new ParentDto(), new ParentDto());
        when(parentService.getAllParents()).thenReturn(parentList);

        // Act
        ResponseEntity<List<ParentDto>> response = parentController.getAllParents();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(parentList, response.getBody());
    }
}
