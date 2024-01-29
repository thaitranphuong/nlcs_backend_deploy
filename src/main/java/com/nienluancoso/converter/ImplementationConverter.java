package com.nienluancoso.converter;


import org.springframework.stereotype.Component;

import com.nienluancoso.dto.ImplementationDTO;
import com.nienluancoso.entity.ImplementationEntity;

@Component
public class ImplementationConverter {
	public ImplementationEntity toEntity(ImplementationDTO implementationDTO) {
		ImplementationEntity implementationEntity = new ImplementationEntity();
		implementationEntity.setScore(implementationDTO.getScore());
		return implementationEntity;
	}
	
//	public ImplementationEntity toEntity(ImplementationDTO implementationDTO, ImplementationEntity implementationEntity) {
//		implementationEntity.setScore(implementationDTO.getScore());
//		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
//		Date date;
//		try {
//			date = (Date) formatter.parse(implementationDTO.getDate());
//		} catch (ParseException e) {
//			date = new Date(0);
//		}
//		implementationEntity.setDate(date);
//		return implementationEntity;
//	}
	
	public ImplementationDTO toDTO(ImplementationEntity implementationEntity) {
		ImplementationDTO implementationDTO = new ImplementationDTO();
		implementationDTO.setId(implementationEntity.getId());
		implementationDTO.setScore(implementationEntity.getScore());
		implementationDTO.setDate(implementationEntity.getDate());
		return implementationDTO;
	}
}
