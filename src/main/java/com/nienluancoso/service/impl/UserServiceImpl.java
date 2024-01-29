package com.nienluancoso.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nienluancoso.converter.UserConverter;
import com.nienluancoso.dto.UserDTO;
import com.nienluancoso.entity.RoleEntity;
import com.nienluancoso.entity.UserEntity;
import com.nienluancoso.repository.RoleRepository;
import com.nienluancoso.repository.UserRepository;
import com.nienluancoso.service.UserService;

@Component
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RoleRepository roleRepo;
	
	@Autowired
	private UserConverter userConverter;
	
	@Override
	public UserDTO save(UserDTO userDTO) {
		UserDTO userResponse = new UserDTO();
		if(userDTO.getId() == 0) {
			if(userRepo.findByEmail(userDTO.getEmail()) == null) {
				UserEntity userEntity = userConverter.toEntity(userDTO);
				Optional<RoleEntity> roleEntity = roleRepo.findById(userDTO.getRole_id());
				userEntity.setRole(roleEntity.get());
				userResponse = userConverter.toDTO(userRepo.save(userEntity));
			}			
		} else {
			Optional<UserEntity> userEntity = userRepo.findById(userDTO.getId());
			UserEntity result = userConverter.toEntity(userDTO, userEntity.get());
			userResponse = userConverter.toDTO(userRepo.save(result));
		}
		return userResponse;
	}

	@Override
	public UserDTO authenticate(UserDTO userDTO) {
		UserDTO userResponse = new UserDTO();
		UserEntity userEntity = userRepo.findByEmail(userDTO.getEmail());
		if(userEntity == null ) {
			userResponse.setId(0);			
		} else if(userEntity.getPassword().equals(userDTO.getPassword())) {
			userResponse = userConverter.toDTO(userEntity);
		} else {
			userResponse.setId(0);	
		}
		return userResponse;
	}

	@Override
	public UserDTO findOneById(Long id) {
		Optional<UserEntity> userEntity = userRepo.findById(id);
		UserDTO userDTO = new UserDTO();
		if(userEntity.isPresent()) {
			userDTO = userConverter.toDTO(userEntity.get());
		} else {
			userDTO.setId(0);
		}
		return userDTO;
	}

	@Override
	public List<UserDTO> findByClassId(Long class_id) {
		List<UserEntity> userEntities = userRepo.findByClassId(class_id);
		List<UserDTO> result = new ArrayList<>();
		for(UserEntity item : userEntities) {
			UserDTO userDTO = userConverter.toDTO(item);
			result.add(userDTO);
		}
		return result; 
	}

	@Override
	public List<UserDTO> findByClassIdAndName(Long class_id, String name) {
		List<UserEntity> userEntities = userRepo.findByClassId(class_id);
		List<UserDTO> listUserDTO = new ArrayList<>();
		for(UserEntity item : userEntities) {
			UserDTO userDTO = userConverter.toDTO(item);
			listUserDTO.add(userDTO);
		}
		List<UserDTO> result = new ArrayList<>();
		for(UserDTO item : listUserDTO) {
			if(item.getName().toLowerCase().contains(name.toLowerCase())) {
				result.add(item);
			}
		}
		return result; 
	}

}
