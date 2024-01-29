package com.nienluancoso.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nienluancoso.converter.AnswerConverter;
import com.nienluancoso.converter.ImplementationConverter;
import com.nienluancoso.converter.OptionConverter;
import com.nienluancoso.dto.AnswerDTO;
import com.nienluancoso.dto.ImplementationDTO;
import com.nienluancoso.dto.OptionDTO;
import com.nienluancoso.dto.QuestionOptionDTO;
import com.nienluancoso.entity.AnswerEntity;
import com.nienluancoso.entity.ExamEntity;
import com.nienluancoso.entity.ImplementationEntity;
import com.nienluancoso.entity.OptionEntity;
import com.nienluancoso.entity.QuestionEntity;
import com.nienluancoso.entity.UserEntity;
import com.nienluancoso.repository.AnswerRepository;
import com.nienluancoso.repository.ExamRepository;
import com.nienluancoso.repository.ImplementationRepository;
import com.nienluancoso.repository.UserRepository;
import com.nienluancoso.service.ImplementationService;

@Component
public class ImplementationServiceImpl implements ImplementationService{

	@Autowired
	private ImplementationRepository implementationRepo;
	
	@Autowired
	private ImplementationConverter implementationConverter;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ExamRepository examRepository;
	
	@Autowired
	private AnswerRepository answerRepository;
	
	@Autowired
	private AnswerConverter answerConverter;
	
	@Autowired
	private OptionConverter optionConverter;
	
	@Override
	public List<ImplementationDTO> findByExamId(Long id) {
		List<ImplementationEntity> implementationEntities = implementationRepo.findByExamId(id);
		List<ImplementationDTO> result = new ArrayList<>();
		for(ImplementationEntity item : implementationEntities) {
			ImplementationDTO implementationDTO = implementationConverter.toDTO(item);
			implementationDTO.setStudent_id(item.getStudent().getId());
			implementationDTO.setStudent_name(item.getStudent().getName());
			implementationDTO.setExam_id(item.getExam().getId());
			result.add(implementationDTO);
		}
		return result;
	}

	@Override
	public List<ImplementationDTO> findByExamIdAndStudentId(Long exam_id, Long student_id) {
		List<ImplementationEntity> implementationEntities = implementationRepo.findByExamIdAndStudentId(exam_id, student_id);
		List<ImplementationDTO> result = new ArrayList<>();
		for(ImplementationEntity item : implementationEntities) {
			ImplementationDTO implementationDTO = implementationConverter.toDTO(item);
			implementationDTO.setStudent_id(item.getStudent().getId());
			implementationDTO.setStudent_name(item.getStudent().getName());
			implementationDTO.setExam_id(item.getExam().getId());
			result.add(implementationDTO);
		}
		return result;
	}

	@Override
	public Long save(ImplementationDTO implementationDTO) {
		ImplementationEntity implementationEntity = implementationConverter.toEntity(implementationDTO);
		Optional<UserEntity> student = userRepository.findById(implementationDTO.getStudent_id());
		Optional<ExamEntity> exam = examRepository.findById(implementationDTO.getExam_id());
		implementationEntity.setStudent(student.get());
		implementationEntity.setExam(exam.get());
		return implementationRepo.save(implementationEntity).getId();
	}

	@Override
	public ImplementationDTO findById(Long id) {
		ImplementationEntity implementationEntity = implementationRepo.findById(id).orElse(null);
		List<AnswerEntity> listAnswer = answerRepository.findAllByImplementationId(id);
		ImplementationDTO implementationDTO = implementationConverter.toDTO(implementationEntity);
		List<AnswerDTO> listAnswerDTO = new ArrayList<>();
		listAnswer.forEach(item -> {
			AnswerDTO answerDTO = answerConverter.toDTO(item);
			QuestionEntity question = item.getQuestion();
			QuestionOptionDTO questionOptionDTO = new QuestionOptionDTO();
			questionOptionDTO.setId(question.getId());
			questionOptionDTO.setContent(question.getContent());
			questionOptionDTO.setCorrect(question.getCorrect());
			questionOptionDTO.setScore(question.getScore());
			questionOptionDTO.setImage(question.getImage());
			questionOptionDTO.setExam_id(id);
			List<OptionEntity> optionEntities = question.getOptions();
			List<OptionDTO> optionDTOs = new ArrayList<>();
			for(OptionEntity optionEntity : optionEntities) {
				optionDTOs.add(optionConverter.toDTO(optionEntity));
			}
			questionOptionDTO.setOptions(optionDTOs);
			answerDTO.setQuestion(questionOptionDTO);
			listAnswerDTO.add(answerDTO);
		});
		implementationDTO.setAnswers(listAnswerDTO);
		implementationDTO.setStudent_id(implementationEntity.getStudent().getId());
		implementationDTO.setStudent_name(implementationEntity.getStudent().getName());
		implementationDTO.setExam_id(implementationEntity.getExam().getId());
		implementationDTO.setExam_name(implementationEntity.getExam().getName());
		return implementationDTO;
	}

}
