package com.app.schoolparent.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import com.app.schoolparent.dto.ParentDto;
import com.app.schoolparent.entity.ParentDetails;
import com.app.schoolparent.repository.ParentRepository;

@ExtendWith(MockitoExtension.class)
public class ParentServiceImplTest {

    @Mock
    private ParentRepository parentRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private ParentServiceImpl parentService;

    @Test
    void testSaveParent() {
        // Arrange
        ParentDto parentDto = new ParentDto();
        // Set properties of parentDto

        ParentDetails parentDetails = new ParentDetails();
        // Set properties of parentDetails

        when(modelMapper.map(parentDto, ParentDetails.class)).thenReturn(parentDetails);
        when(parentRepository.save(any(ParentDetails.class))).thenReturn(parentDetails);
        when(modelMapper.map(parentDetails, ParentDto.class)).thenReturn(parentDto);

        // Act
        ParentDto savedParentDto = parentService.saveParent(parentDto);

        // Assert
        assertEquals(parentDto, savedParentDto);
    }

    @Test
    void testUpdateParent() {
        // Arrange
        Integer parentId = 1;
        ParentDto parentDto = new ParentDto();
        // Set properties of parentDto

        ParentDetails existingParent = new ParentDetails();
        // Set properties of existingParent

        when(parentRepository.findById(parentId)).thenReturn(java.util.Optional.of(existingParent));
        when(parentRepository.save(any(ParentDetails.class))).thenReturn(existingParent);
        when(modelMapper.map(existingParent, ParentDto.class)).thenReturn(parentDto);

        // Act
        ParentDto updatedParentDto = parentService.updateParent(parentId, parentDto);

        // Assert
        assertEquals(parentDto, updatedParentDto);
    }

    @Test
    void testGetDetails() {
        // Arrange
        Integer parentId = 1;
        ParentDetails existingParent = new ParentDetails();
        // Set properties of existingParent

        when(parentRepository.findById(parentId)).thenReturn(java.util.Optional.of(existingParent));
        ParentDto expectedParentDto = modelMapper.map(existingParent, ParentDto.class);

        // Act
        ParentDto retrievedParentDto = parentService.getDetails(parentId);

        // Assert
        assertEquals(expectedParentDto, retrievedParentDto);
    }

    @Test
    void testGetAllParents() {
        // Arrange
        List<ParentDetails> parentList = new ArrayList<>();
        // Add some ParentDetails to the list

        when(parentRepository.findAll()).thenReturn(parentList);

        List<ParentDto> expectedParentDtoList = parentList.stream()
                .map(parent -> modelMapper.map(parent, ParentDto.class))
                .collect(Collectors.toList());

        // Act
        List<ParentDto> retrievedParentDtoList = parentService.getAllParents();

        // Assert
        assertEquals(expectedParentDtoList.size(), retrievedParentDtoList.size());
        for (int i = 0; i < expectedParentDtoList.size(); i++) {
            assertEquals(expectedParentDtoList.get(i), retrievedParentDtoList.get(i));
        }
    }
}
