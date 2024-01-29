package com.nienluancoso.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nienluancoso.dto.UserDTO;

@Service
public interface UserService {
	public UserDTO save(UserDTO userDTO);
	public UserDTO authenticate(UserDTO userDTO);
	public UserDTO findOneById(Long id);
	public List<UserDTO> findByClassId(Long class_id);
	public List<UserDTO> findByClassIdAndName(Long class_id, String name);
	
}
