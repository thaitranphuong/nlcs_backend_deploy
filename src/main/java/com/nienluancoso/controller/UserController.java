package com.nienluancoso.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nienluancoso.dto.UserDTO;
import com.nienluancoso.service.UserService;

import jakarta.servlet.http.HttpSession;

@RestController
@CrossOrigin
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/user/get-user")
	public UserDTO getUser(@RequestBody Long id) {
		UserDTO reponseUser = userService.findOneById(id);
		return reponseUser;
	}
	
	@PostMapping("/auth/login")
	public UserDTO login(@RequestBody UserDTO userDTO, HttpSession session) {
		UserDTO result = userService.authenticate(userDTO);
		if(result.getId() != 0) {
			session.setAttribute(String.valueOf(result.getId()), result);
		}
		return result;
		//return (UserDTO) session.getAttribute(String.valueOf(result.getId()));
	}
	
	@PostMapping("/auth/register")
	public UserDTO register(@RequestBody UserDTO userDTO) {
		UserDTO reponseUser = userService.save(userDTO);
		return reponseUser;
	}
	
	@GetMapping("/user/get-students/{class_id}")
	public List<UserDTO> getStudentByClassID(@PathVariable(name="class_id") Long id,
			@RequestParam(value = "name", defaultValue = "none") String name)
	{
		List<UserDTO> students = new ArrayList<>();
		if (!name.equals("none")) {
			students = userService.findByClassIdAndName(id, name);	
		} else {
			students = userService.findByClassId(id);	
		}
		return students;
	}
	
	@PostMapping("/auth/update-info")
	public UserDTO update(@RequestBody UserDTO userDTO) {
		UserDTO reponseUser = userService.save(userDTO);
		return reponseUser;
	}
}
