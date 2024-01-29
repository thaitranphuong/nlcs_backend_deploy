package com.nienluancoso.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nienluancoso.dto.ImplementationDTO;

@Service
public interface ImplementationService {
	public List<ImplementationDTO> findByExamId(Long id);
	public List<ImplementationDTO> findByExamIdAndStudentId(Long exam_id, Long student_id);
	public Long save(ImplementationDTO implementationDTO);
	public ImplementationDTO findById(Long id);
}
