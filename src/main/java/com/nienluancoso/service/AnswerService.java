package com.nienluancoso.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nienluancoso.dto.AnswerDTO;

@Service
public interface AnswerService {
	public void saveAll(List<AnswerDTO> listAnswer);
}
