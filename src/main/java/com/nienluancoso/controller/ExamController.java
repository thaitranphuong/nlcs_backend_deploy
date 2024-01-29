package com.nienluancoso.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nienluancoso.dto.ExamDTO;
import com.nienluancoso.service.ExamService;

@RestController
@CrossOrigin
public class ExamController {
	
	@Autowired
	private ExamService examService;
	
	@PostMapping("/exam/create-update")
	public Long save(@RequestBody ExamDTO examDTO) {
		Long id = examService.save(examDTO);
		return id;
	}
	
	@GetMapping("/exam/get-exams/{teacher_id}")
	public List<ExamDTO> getExamByTeacherId(@PathVariable(name="teacher_id") Long id,
			@RequestParam(value = "name", defaultValue = "none") String name)
	{
		List<ExamDTO> exams = new ArrayList<>();
		if (!name.equals("none")) {
			exams = examService.findByTeacherIdAndName(id, name);	
		} else {
			exams = examService.findByTeacherId(id);	
		}
		return exams;
	}
	
	@GetMapping("/exam/get-exam/{id}")
	public ExamDTO findById(@PathVariable Long id) {
		ExamDTO result = examService.findById(id);
		return result;
	}
	
	@DeleteMapping("/exam/delete/{id}")
	public void deleteById(@PathVariable Long id) {
		examService.deleteById(id);
		return;
	}
	
	@GetMapping("/exam/get-exams-by-classroom/{class_id}")
	public List<ExamDTO> getExamByClassId(@PathVariable(name="class_id") Long id)
	{
		List<ExamDTO> exams = examService.findByClassId(id);
		return exams;
	}
}
