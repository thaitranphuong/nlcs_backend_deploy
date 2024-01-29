package com.nienluancoso.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nienluancoso.dto.QuestionDTO;
import com.nienluancoso.dto.QuestionOptionDTO;

@Service
public interface QuestionService {
	public List<Long> saveAll(List<QuestionDTO> listQuestionDTO);
	public QuestionDTO save(QuestionDTO questionDTO);
	public List<QuestionDTO> findAllByExamId(Long id);
	public List<QuestionOptionDTO>  findAllAndOptionByExamId(Long id); 
}
