package com.nienluancoso.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nienluancoso.converter.AnswerConverter;
import com.nienluancoso.dto.AnswerDTO;
import com.nienluancoso.entity.AnswerEntity;
import com.nienluancoso.entity.ImplementationEntity;
import com.nienluancoso.entity.QuestionEntity;
import com.nienluancoso.repository.AnswerRepository;
import com.nienluancoso.repository.ImplementationRepository;
import com.nienluancoso.repository.QuestionRepository;
import com.nienluancoso.service.AnswerService;

@Component
public class AnswerServiceImpl implements AnswerService {
	
	@Autowired
	private AnswerRepository answerRepository;
	
	@Autowired
	private AnswerConverter answerConverter;
	
	@Autowired
	private ImplementationRepository implementationRepository;
	
	@Autowired
	private QuestionRepository questionRepository;

	@Override
	public void saveAll(List<AnswerDTO> listAnswer) {
		List<AnswerEntity> answerEntities = new ArrayList<>();
		listAnswer.forEach(item -> {
			AnswerEntity answerEntity = answerConverter.toEntity(item);
			Optional<ImplementationEntity> implementationEntity = implementationRepository.findById(item.getImplementation_id());
			Optional<QuestionEntity> questionEntity = questionRepository.findById(item.getQuestion_id());
			answerEntity.setImplementation(implementationEntity.get());
			answerEntity.setQuestion(questionEntity.get());
			answerEntities.add(answerEntity);
		});
		answerRepository.saveAll(answerEntities);
	}

}
