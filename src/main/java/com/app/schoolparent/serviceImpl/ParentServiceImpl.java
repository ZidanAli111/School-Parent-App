package com.app.schoolparent.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.schoolparent.dto.ParentDto;
import com.app.schoolparent.entity.ParentDetails;
import com.app.schoolparent.repository.ParentRepository;
import com.app.schoolparent.service.ParentService;

@Service
public class ParentServiceImpl implements ParentService{
	
     @Autowired
     private ParentRepository parentRepository;
     
     @Autowired
     private ModelMapper modelMapper;

	@Override
	public ParentDto saveParent(ParentDto parentDto) {
		ParentDetails parentDetails = modelMapper.map(parentDto, ParentDetails.class);
		ParentDetails savedParent = parentRepository.save(parentDetails);
		return modelMapper.map(savedParent, ParentDto.class);
	}
	

//	@Override
//	public ParentDto updateParent(Integer parentId, ParentDto parentDto) {
//		ParentDetails existingParent = parentRepository.findById(parentId).orElseThrow(()-> new RuntimeException("Parent not found"));
//		modelMapper.map(parentDto, existingParent);
//		ParentDetails updatedParent = parentRepository.save(existingParent);
//		return modelMapper.map(updatedParent, ParentDto.class);
//	}
	@Override
	public ParentDto updateParent(Integer parentId, ParentDto parentDto) {
			ParentDetails existingParent = parentRepository.findById(parentId).orElseThrow(()->new RuntimeException("Parent not found"));
//			existingParent.setParentId(0);
			existingParent.setParentName(parentDto.getParentName());
  		    existingParent.setStudentName(parentDto.getStudentName());
			existingParent.setAddress(parentDto.getAddress());
			existingParent.setAge(parentDto.getAge());
			existingParent.setCity(parentDto.getCity());
			existingParent.setCountry(parentDto.getCountry());
			existingParent.setEmailAddress(parentDto.getEmailAddress());
			existingParent.setParentName(parentDto.getParentName());
			existingParent.setState(parentDto.getState());
			existingParent.setPrimaryContactPerson(parentDto.getPrimaryContactPerson());
			existingParent.setPrimaryContactPersonMobile(parentDto.getPrimaryContactPersonMobile());
			existingParent.setSecondaryContactPerson(parentDto.getSecondaryContactPerson());
			existingParent.setSecondaryContactPersonMobile(parentDto.getSecondaryContactPersonMobile());
			ParentDetails updatedParent = parentRepository.save(existingParent);
			return converToParentDto(updatedParent);
	}
 
	private ParentDto converToParentDto(ParentDetails parentDetails) {
		ParentDto parentDto = new ParentDto();
		parentDto.setParentId(parentDetails.getParentId());
		parentDto.setParentName(parentDetails.getParentName());
		parentDto.setStudentName(parentDetails.getStudentName());
		parentDto.setEmailAddress(parentDetails.getEmailAddress());
		parentDto.setAge(parentDetails.getAge());
		parentDto.setAddress(parentDetails.getAddress());
		parentDto.setCity(parentDetails.getCity());
		parentDto.setCountry(parentDetails.getCountry());
		parentDto.setZipCode(parentDetails.getZipCode());
		parentDto.setState(parentDetails.getState());
		parentDto.setStudentRegisterNumber(parentDetails.getStudentRegisterNumber());
		parentDto.setPrimaryContactPerson(parentDetails.getPrimaryContactPerson());
		parentDto.setPrimaryContactPersonMobile(parentDetails.getSecondaryContactPerson());
		parentDto.setSecondaryContactPerson(parentDetails.getSecondaryContactPersonMobile());
		return parentDto;
	}   


	@Override
	public ParentDto getDetails(Integer parentId) {
		ParentDetails existingParent=parentRepository.findById(parentId).orElseThrow(()-> new RuntimeException("Parent not found"));
		return modelMapper.map(existingParent,ParentDto.class);
	}


	@Override
	public List<ParentDto> getAllParents() {
		List<ParentDetails> parentList=parentRepository.findAll();
		List<ParentDto> parentDtoList=parentList.stream().map(parent->modelMapper.map(parent, ParentDto.class)).collect(Collectors.toList());
		return parentDtoList;
	}
	
	public ParentDto parentToDto(ParentDetails parentDetails) {
		ParentDto parentDto = modelMapper.map(parentDetails, ParentDto.class);
		return parentDto;
	}
     
     
}
