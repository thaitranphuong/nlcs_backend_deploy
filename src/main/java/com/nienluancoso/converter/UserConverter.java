package com.nienluancoso.converter;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.nienluancoso.dto.UserDTO;
import com.nienluancoso.entity.UserEntity;


@Component
public class UserConverter {
	public UserEntity toEntity(UserDTO userDTO) {
		UserEntity userEntity = new UserEntity();
		userEntity.setName(userDTO.getName());
		userEntity.setAdress(userDTO.getAdress());
		userEntity.setEmail(userDTO.getEmail());
		userEntity.setGender(userDTO.isGender());
		userEntity.setPhone(userDTO.getPhone());
		userEntity.setPassword(userDTO.getPassword());
		return userEntity;
	}
	
	public UserDTO toDTO(UserEntity userEntity) {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(userEntity.getId());
		userDTO.setName(userEntity.getName());
		userDTO.setAdress(userEntity.getAdress());
		userDTO.setBirthday(userEntity.getBirthday());
		userDTO.setEmail(userEntity.getEmail());
		userDTO.setGender(userEntity.isGender());
		userDTO.setPhone(userEntity.getPhone());
		userDTO.setRole_id(userEntity.getRole().getId());
		return userDTO;
	}
	

	public UserEntity toEntity(UserDTO userDTO, UserEntity userEntity) {
		userEntity.setName(userDTO.getName());
		userEntity.setAdress(userDTO.getAdress());
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date;
		try {
			date = formatter.parse(userDTO.getBirthday());
		} catch (ParseException e) {
			date = new Date(0);
		}
		userEntity.setBirthday(date);
		userEntity.setGender(userDTO.isGender());
		userEntity.setPhone(userDTO.getPhone());
		return userEntity;
	}
}
