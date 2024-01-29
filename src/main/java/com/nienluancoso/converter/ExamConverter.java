package com.nienluancoso.converter;

import org.springframework.stereotype.Component;

import com.nienluancoso.dto.ExamDTO;
import com.nienluancoso.entity.ExamEntity;

@Component
public class ExamConverter {
	public ExamEntity toEntity(ExamDTO examDTO) {
		ExamEntity examEntity = new ExamEntity();
		examEntity.setName(examDTO.getName());
		examEntity.setTime(examDTO.getTime());
		examEntity.setVisibility(examDTO.isVisibility());
		return examEntity;
	}
	
	public ExamEntity toEntity(ExamDTO examDTO, ExamEntity examEntity) {
		examEntity.setName(examDTO.getName());
		examEntity.setTime(examDTO.getTime());
		examEntity.setVisibility(examDTO.isVisibility());
		return examEntity;
	}
	
	public ExamDTO toDTO(ExamEntity examEntity) {
		ExamDTO examDTO = new ExamDTO();
		examDTO.setId(examEntity.getId());
		examDTO.setName(examEntity.getName());
		examDTO.setTime(examEntity.getTime());
		examDTO.setVisibility(examEntity.isVisibility());
		return examDTO;
	}
}
