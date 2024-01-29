package com.nienluancoso.converter;

import org.springframework.stereotype.Component;

import com.nienluancoso.dto.ClassDTO;
import com.nienluancoso.entity.ClassEntity;


@Component
public class ClassConverter {
	public ClassEntity toEntity(ClassDTO classDTO) {
		ClassEntity classEntity = new ClassEntity();
		classEntity.setName(classDTO.getName());
		classEntity.setSchoolYear(classDTO.getSchoolYear());
		return classEntity;
	}
	
	public ClassEntity toEntity(ClassDTO classDTO, ClassEntity classEntity) {
		classEntity.setName(classDTO.getName());
		classEntity.setSchoolYear(classDTO.getSchoolYear());
		return classEntity;
	}
	
	public ClassDTO toDTO(ClassEntity classEntity) {
		ClassDTO classDTO = new ClassDTO();
		classDTO.setId(classEntity.getId());
		classDTO.setName(classEntity.getName());
		classDTO.setSchoolYear(classEntity.getSchoolYear());
		classDTO.setTeacherName(classEntity.getTeacher().getName());
		return classDTO;
	}
}
