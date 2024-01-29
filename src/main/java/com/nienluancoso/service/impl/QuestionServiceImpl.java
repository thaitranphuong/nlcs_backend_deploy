package com.nienluancoso.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nienluancoso.converter.OptionConverter;
import com.nienluancoso.converter.QuestionConverter;
import com.nienluancoso.dto.OptionDTO;
import com.nienluancoso.dto.QuestionDTO;
import com.nienluancoso.dto.QuestionOptionDTO;
import com.nienluancoso.entity.ExamEntity;
import com.nienluancoso.entity.OptionEntity;
import com.nienluancoso.entity.QuestionEntity;
import com.nienluancoso.repository.ExamRepository;
import com.nienluancoso.repository.QuestionRepository;
import com.nienluancoso.service.QuestionService;

@Component
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionRepository questionRepo;
	
	@Autowired
	private QuestionConverter questionConverter;
	
	@Autowired
	private ExamRepository examRepo;
	
	@Autowired
	private OptionConverter optionConverter;

	@Override
	public QuestionDTO save(QuestionDTO questionDTO) {
		QuestionEntity result = new QuestionEntity();
		if(questionDTO.getId() == 0) {
			result = questionConverter.toEntity(questionDTO);
		} else {
			Optional<QuestionEntity> questionEntity = questionRepo.findById(questionDTO.getId());
			result = questionConverter.toEntity(questionDTO, questionEntity.get());
		}
		Optional<ExamEntity> exam = examRepo.findById(questionDTO.getExam_id());
		result.setExam(exam.get());
		return questionConverter.toDTO(questionRepo.save(result));
	}

	
	@Override
	public List<Long> saveAll(List<QuestionDTO> listQuestionDTO) {
		List<Long> listId = new ArrayList<>();
		for(QuestionDTO questionDTO: listQuestionDTO) {
			Long id = save(questionDTO).getId();
			listId.add(id);	
		}
		return listId;
	}


	@Override
	public List<QuestionDTO> findAllByExamId(Long id) {
		List<QuestionDTO> result = new ArrayList<>();
		List<QuestionEntity> listQuestionEntity = questionRepo.findAllByExamId(id);
			for(QuestionEntity item : listQuestionEntity) {
				QuestionDTO questionDTO = questionConverter.toDTO(item);
				questionDTO.setExam_id(item.getExam().getId());
				result.add( questionConverter.toDTO(item));
			}
		return result;
	}


	@Override
	public List<QuestionOptionDTO> findAllAndOptionByExamId(Long id) {
		List<QuestionOptionDTO> result = new ArrayList<>();
		List<QuestionEntity> listQuestionEntity = questionRepo.findAllByExamId(id);
			for(QuestionEntity item : listQuestionEntity) {
				QuestionOptionDTO questionOptionDTO = new QuestionOptionDTO();
				questionOptionDTO.setId(item.getId());
				questionOptionDTO.setContent(item.getContent());
				questionOptionDTO.setCorrect(item.getCorrect());
				questionOptionDTO.setScore(item.getScore());
				questionOptionDTO.setImage(item.getImage());
				questionOptionDTO.setExam_id(id);
				List<OptionEntity> optionEntities = item.getOptions();
				List<OptionDTO> optionDTOs = new ArrayList<>();
				for(OptionEntity optionEntity : optionEntities) {
					optionDTOs.add(optionConverter.toDTO(optionEntity));
				}
				questionOptionDTO.setOptions(optionDTOs);
				result.add(questionOptionDTO);
			}
		return result;
	}

	

	
}
