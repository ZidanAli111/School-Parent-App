package com.app.schoolparent.service;

import java.util.List;

import com.app.schoolparent.dto.ParentDto;
import com.app.schoolparent.entity.ParentDetails;

public interface ParentService {
	ParentDto saveParent(ParentDto parentDto);
	ParentDto updateParent(Integer parentId,ParentDto parentDto);
	ParentDto getDetails(Integer parentId);
	List<ParentDto> getAllParents();
	

}
