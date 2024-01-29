package com.nienluancoso.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nienluancoso.dto.ClassDTO;

@Service
public interface ClassService {
	public void save(ClassDTO classDTO);
	public List<ClassDTO> findByTeacherid(Long teacher);
	public List<ClassDTO> findByTeacheridAndName(Long teacher_id, String name);
	public void delete(Long id);
	public ClassDTO findById(Long id);
	public void removeStudent(Long student_id, Long class_id);
	public List<ClassDTO> findByStudentId(Long id, int page, int limit);
	public List<ClassDTO> findByStudentId(Long id, int page, int limit, String name);
	public int totalItem(Long id);
	public int totalItem(Long id, String name);
	public void joinClass(Long id_class, Long id_student);
	public List<ClassDTO> findJoinedClassByStudentId(Long id_student);
}
