package com.nienluancoso.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nienluancoso.dto.OptionDTO;

@Service
public interface OptionService {
	public OptionDTO save(OptionDTO optionDTO);
	public void saveAll(List<OptionDTO> listOptionDTO);
	
}
