package com.nienluancoso.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nienluancoso.converter.OptionConverter;
import com.nienluancoso.dto.OptionDTO;
import com.nienluancoso.entity.OptionEntity;
import com.nienluancoso.entity.QuestionEntity;
import com.nienluancoso.repository.OptionRepository;
import com.nienluancoso.repository.QuestionRepository;
import com.nienluancoso.service.OptionService;

@Component
public class OptionServiceImpl implements OptionService {
	@Autowired
	private OptionRepository optionRepo;
	
	@Autowired
	private QuestionRepository questionRepo;
	
	@Autowired
	private OptionConverter optionConverter;
	
	@Override
	public OptionDTO save(OptionDTO optionDTO) {
		OptionEntity result = new OptionEntity();
		if(optionDTO.getId() == 0) {
			result = optionConverter.toEntity(optionDTO);
		}
		else {
			java.util.Optional<OptionEntity> optionEntity = optionRepo.findById(optionDTO.getId());
			result = optionConverter.toEntity(optionDTO, optionEntity.get());
		}
		java.util.Optional<QuestionEntity> question = questionRepo.findById(optionDTO.getQuestion_id());
		result.setQuestion(question.get());
		return optionConverter.toDTO(optionRepo.save(result));
	}


	@Override
	public void saveAll(List<OptionDTO> listOptionDTO) {
		for(OptionDTO optionDTO: listOptionDTO) {
			save(optionDTO);
		}
		return;
	}
	
	

}
