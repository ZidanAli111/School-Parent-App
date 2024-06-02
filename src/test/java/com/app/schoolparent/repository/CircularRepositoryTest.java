package com.app.schoolparent.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.app.schoolparent.entity.CircularDetails;

@DataJpaTest
public class CircularRepositoryTest {

    @Autowired
    private CircularRepository circularRepository;

    @Test
    public void testSaveCircular() {
        // Arrange
        CircularDetails circular = new CircularDetails();
        circular.setStaffId(1); // Set staff id or any other required fields
        // Set other circular details...

        // Act
        CircularDetails savedCircular = circularRepository.save(circular);

        // Assert
        assertNotNull(savedCircular);
        assertNotNull(savedCircular.getStaffId()); // Assuming getStaffId() returns the primary key or the ID field
    }

    @Test
    public void testFindAll() {
        // Act
        List<CircularDetails> circulars = circularRepository.findAll();

        // Assert
        assertTrue(circulars.isEmpty()); // Assuming no circulars are initially present
    }

    @Test
    public void testFindById() {
        // Arrange
        CircularDetails circular = new CircularDetails();
        // Set circular details...
        CircularDetails savedCircular = circularRepository.save(circular);

        // Act
        Optional<CircularDetails> optionalCircular = circularRepository.findById(savedCircular.getStaffId());

        // Assert
        assertTrue(optionalCircular.isPresent());
        assertEquals(savedCircular.getStaffId(), optionalCircular.get().getStaffId());
    }

    @Test
    public void testDelete() {
        // Arrange
        CircularDetails circular = new CircularDetails();
        // Set circular details...
        CircularDetails savedCircular = circularRepository.save(circular);

        // Act
        circularRepository.delete(savedCircular);

        // Assert
        assertEquals(Optional.empty(), circularRepository.findById(savedCircular.getStaffId()));
    }

    // Additional test cases can be added for custom queries or methods in CircularRepository
}
