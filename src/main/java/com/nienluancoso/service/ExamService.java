package com.nienluancoso.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nienluancoso.dto.ExamDTO;


@Service
public interface ExamService {
	public Long save(ExamDTO examDTO);
	public List<ExamDTO> findByTeacherIdAndName(Long id, String name);	
	public List<ExamDTO> findByTeacherId(Long id);
	public ExamDTO findById(Long id);
	public void deleteById(Long id);
	public List<ExamDTO> findByClassId(Long class_id);
}
