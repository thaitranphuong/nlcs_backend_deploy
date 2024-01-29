package com.nienluancoso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nienluancoso.dto.AnswerDTO;
import com.nienluancoso.service.AnswerService;

@RestController
@CrossOrigin
public class AnswerController {
	
	@Autowired
	private AnswerService answerService;
	
	@PostMapping("/answer/save-answers")
	public void saveAll(@RequestBody List<AnswerDTO> listAnswer) {
		answerService.saveAll(listAnswer);
	}
}
