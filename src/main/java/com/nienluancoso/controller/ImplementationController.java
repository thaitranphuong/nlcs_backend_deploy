package com.nienluancoso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nienluancoso.dto.ImplementationDTO;
import com.nienluancoso.service.ImplementationService;

@RestController
@CrossOrigin
public class ImplementationController {
	
	@Autowired
	private ImplementationService implementationService;
	
	@GetMapping("/implementation/get-by-exam/{exam_id}")
	public List<ImplementationDTO> getByExam(@PathVariable(name="exam_id") Long id) {
		List<ImplementationDTO> result = implementationService.findByExamId(id);
		return result;
	}
	
	@GetMapping("/implementation/get-by-exam-and-student/{exam_id}/{student_id}")
	public List<ImplementationDTO> getByExamAndStudent(@PathVariable(name="exam_id") Long exam_id,
									@PathVariable(name="student_id") Long student_id) {
		List<ImplementationDTO> result = implementationService.findByExamIdAndStudentId(exam_id, student_id);
		return result;
	}
	
	@PostMapping("/implementation/save")
	public Long save(@RequestBody ImplementationDTO implementationDTO) {
		return implementationService.save(implementationDTO);
	}
	
	@GetMapping("/implementation/get-by-id/{id}")
	public ImplementationDTO getById(@PathVariable(name="id") Long id) {
		ImplementationDTO result = implementationService.findById(id);
		return result;
	}
}
