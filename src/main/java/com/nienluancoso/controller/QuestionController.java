package com.nienluancoso.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.nienluancoso.dto.QuestionDTO;
import com.nienluancoso.dto.QuestionOptionDTO;
import com.nienluancoso.service.QuestionService;

@RestController
@CrossOrigin
public class QuestionController {
	
	@Autowired
	private QuestionService quesitonService;
	
	@PostMapping("/question/create-update-list")
	public List<Long> saveAll(@RequestBody List<QuestionDTO> listQuestionDTO) {
		List<Long> listId = quesitonService.saveAll(listQuestionDTO);
		return listId;
	}
	
	@PostMapping("/question/create-update")
	public QuestionDTO save(@RequestBody QuestionDTO questionDTO) {
		QuestionDTO result = quesitonService.save(questionDTO);
		return result;
	}
	
	@GetMapping("/question/get_questions/{exam_id}")
	public List<QuestionDTO> findAllByExam(@PathVariable(name = "exam_id") Long id) {
		List<QuestionDTO> result = quesitonService.findAllByExamId(id);
		return result;
	}
	
	@GetMapping("/question/get-questions-and-options/{exam_id}")
	public List<QuestionOptionDTO> getListQuestionByExam(@PathVariable(name = "exam_id") Long id) {
		List<QuestionOptionDTO> result = quesitonService.findAllAndOptionByExamId(id);
		return result;
	}
	
	@PostMapping("/question/create-update-image")
	public void saveFile(@RequestPart("images") MultipartFile[] files) throws IOException {
		Path path = Paths.get("uploads/");
		
		for(MultipartFile file : files) {
			InputStream inputStream = file.getInputStream();
			Files.copy(inputStream, path.resolve(file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
		}
	}
	
	@GetMapping("/question/getimage/{image}")
	public ResponseEntity<ByteArrayResource> getImage(@PathVariable("image") String image) {
		if(!image.equals("") || image != null) {
			try {
				Path filename = Paths.get("uploads", image);
				byte[] buffer = Files.readAllBytes(filename);
				ByteArrayResource byteArrayResource = new ByteArrayResource(buffer);
				return ResponseEntity.ok()
						.contentLength(buffer.length)
						.contentType(MediaType.parseMediaType("image/png"))
						.body(byteArrayResource);
			} catch (Exception e) {
				
			}
		}
		return ResponseEntity.badRequest().build();
	}
}
