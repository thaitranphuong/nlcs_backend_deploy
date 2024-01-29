package com.nienluancoso.converter;

import org.springframework.stereotype.Component;

import com.nienluancoso.dto.QuestionDTO;
import com.nienluancoso.entity.QuestionEntity;

@Component
public class QuestionConverter {

	public QuestionEntity toEntity(QuestionDTO questionDTO) {
		QuestionEntity questionEntity = new QuestionEntity();
		questionEntity.setContent(questionDTO.getContent());
		questionEntity.setScore(questionDTO.getScore());
		questionEntity.setCorrect(questionDTO.getCorrect());
		questionEntity.setImage(questionDTO.getImage());
		return questionEntity;
	}
	
	public QuestionEntity toEntity(QuestionDTO questionDTO, QuestionEntity questionEntity) {
		questionEntity.setContent(questionDTO.getContent());
		questionEntity.setScore(questionDTO.getScore());
		questionEntity.setCorrect(questionDTO.getCorrect());
		questionEntity.setImage(questionDTO.getImage());
		return questionEntity;
	}
	
	public QuestionDTO toDTO(QuestionEntity questionEntity) {
		QuestionDTO questionDTO = new QuestionDTO();
		questionDTO.setId(questionEntity.getId());
		questionDTO.setContent(questionEntity.getContent());
		questionDTO.setScore(questionEntity.getScore());
		questionDTO.setCorrect(questionEntity.getCorrect());
		questionDTO.setCorrect(questionEntity.getCorrect());
		questionDTO.setImage(questionEntity.getImage());
		questionDTO.setExam_id(questionEntity.getExam().getId());
		return questionDTO;
	}
}
