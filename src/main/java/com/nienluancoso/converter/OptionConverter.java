package com.nienluancoso.converter;

import org.springframework.stereotype.Component;

import com.nienluancoso.dto.OptionDTO;
import com.nienluancoso.entity.OptionEntity;

@Component
public class OptionConverter {
	public OptionEntity toEntity(OptionDTO optionDTO) {
		OptionEntity optionEntity = new OptionEntity();
		optionEntity.setContent(optionDTO.getContent());
		optionEntity.setLabel(optionDTO.getLabel());
		return optionEntity;
	}
	
	public OptionEntity toEntity(OptionDTO optionDTO, OptionEntity optionEntity) {
		optionEntity.setContent(optionDTO.getContent());
		optionEntity.setLabel(optionDTO.getLabel());
		return optionEntity;
	}
	
	public OptionDTO toDTO(OptionEntity optionEntity) {
		OptionDTO optionDTO = new OptionDTO();
		optionDTO.setId(optionEntity.getId());
		optionDTO.setContent(optionEntity.getContent());
		optionDTO.setLabel(optionEntity.getLabel());
		optionDTO.setQuestion_id(optionEntity.getQuestion().getId());
		return optionDTO;
	}
}
