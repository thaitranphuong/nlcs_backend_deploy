package com.nienluancoso.converter;

import org.springframework.stereotype.Component;

import com.nienluancoso.dto.AnswerDTO;
import com.nienluancoso.entity.AnswerEntity;

@Component
public class AnswerConverter {
	public AnswerEntity toEntity(AnswerDTO answerDTO) {
		AnswerEntity answerEntity = new AnswerEntity();
		answerEntity.setChoice(answerDTO.getChoice());
		return answerEntity;
	}
	
	public AnswerDTO toDTO(AnswerEntity answerEntity) {
		AnswerDTO answerDTO = new AnswerDTO();
		answerDTO.setId(answerEntity.getId());
		answerDTO.setChoice(answerEntity.getChoice());
		answerDTO.setImplementation_id(answerEntity.getImplementation().getId());
		answerDTO.setQuestion_id(answerEntity.getQuestion().getId());
		return answerDTO;
	}
}
