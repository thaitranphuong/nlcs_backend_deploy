package com.nienluancoso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nienluancoso.dto.OptionDTO;
import com.nienluancoso.service.OptionService;



@RestController
@CrossOrigin
public class OptionController {
	@Autowired
	private OptionService optionService;

	@PostMapping("/option/create-update-list")
	public void saveAll(@RequestBody List<OptionDTO> listOptionDTO) {
		optionService.saveAll(listOptionDTO);
		return;
	}
	
	@PostMapping("/option/create-update")
	public OptionDTO save(@RequestBody OptionDTO optionDTO) {
		OptionDTO result = optionService.save(optionDTO);
		return result;
	}
}
