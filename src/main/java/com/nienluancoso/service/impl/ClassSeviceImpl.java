package com.nienluancoso.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nienluancoso.converter.ClassConverter;
import com.nienluancoso.dto.ClassDTO;
import com.nienluancoso.entity.ClassEntity;
import com.nienluancoso.entity.UserEntity;
import com.nienluancoso.repository.ClassRepository;
import com.nienluancoso.repository.UserRepository;
import com.nienluancoso.service.ClassService;

@Component
public class ClassSeviceImpl implements ClassService {

	@Autowired
	private ClassRepository classRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ClassConverter classConverter;
	
	@Override
	public void save(ClassDTO classDTO) {
		ClassEntity result = new ClassEntity();
		if(classDTO.getId() == 0) {
			result = classConverter.toEntity(classDTO);
		} else {
			Optional<ClassEntity> classEntity = classRepository.findById(classDTO.getId());
			result = classConverter.toEntity(classDTO, classEntity.get());
		}
		Optional<UserEntity> teacher = userRepository.findById(classDTO.getTeacher_id());
		result.setTeacher(teacher.get());
		classRepository.save(result);
		return;
	}

	@Override
	public List<ClassDTO> findByTeacherid(Long teacher_id) {
		List<ClassEntity> classroomEntities = classRepository.findByTeacherid(teacher_id);
		List<ClassDTO> classrooms = new ArrayList<>();
		for(ClassEntity item: classroomEntities) {
			ClassDTO classDTO = classConverter.toDTO(item);
			Set<Long> students_id = new HashSet<>();
			classDTO.setTeacher_id(teacher_id);
			for(UserEntity student : item.getStudents()) {
				students_id.add(student.getId());
			}
			classDTO.setStudents_id(students_id);
			classrooms.add(classDTO);
		}
		return classrooms;
	}

	@Override
	public List<ClassDTO> findByTeacheridAndName(Long teacher_id, String name) {
		List<ClassEntity> classroomEntities = classRepository.findByTeacherid(teacher_id);
		List<ClassDTO> classrooms = new ArrayList<>();
		for(ClassEntity item: classroomEntities) {
			ClassDTO classDTO = classConverter.toDTO(item);
			Set<Long> students_id = new HashSet<>();
			classDTO.setTeacher_id(teacher_id);
			for(UserEntity student : item.getStudents()) {
				students_id.add(student.getId());
			}
			classDTO.setStudents_id(students_id);
			classrooms.add(classDTO);
		}
		List<ClassDTO> result = new ArrayList<>();
		for(ClassDTO item : classrooms) {
			if(item.getName().toLowerCase().contains(name.toLowerCase())) {
				result.add(item);
			}
		}
		return result;
	}

	@Override
	public void delete(Long id) {
		classRepository.deleteById(id);
		return;
	}

	@Override
	public ClassDTO findById(Long id) {
		Optional<ClassEntity> classEntity = classRepository.findById(id);
		ClassDTO result = classConverter.toDTO(classEntity.get());
		Set<UserEntity> students = classEntity.get().getStudents();
		for(UserEntity student: students) {
			result.getStudents_id().add(student.getId());
		}
		return result;
	}

	@Override
	public void removeStudent(Long student_id, Long class_id) {
		Optional<ClassEntity> classEntity = classRepository.findById(class_id);
		Optional<UserEntity> studentEntity = userRepository.findById(student_id);
		classEntity.get().getStudents().remove(studentEntity.get());
		studentEntity.get().getClasses().remove(classEntity.get());
		classRepository.save(classEntity.get());
		userRepository.save(studentEntity.get());
		return;
	}

	@Override
	public List<ClassDTO> findByStudentId(Long id, int page, int limit) {
		List<ClassEntity> classroomEntities = classRepository.findByStudentId(id, page, limit);
		List<ClassDTO> classrooms = new ArrayList<>();
		for(ClassEntity item: classroomEntities) {
			ClassDTO classDTO = classConverter.toDTO(item);
			classDTO.setTeacherName(item.getTeacher().getName());
			classrooms.add(classDTO);
		}
		return classrooms;
	}

	@Override
	public int totalItem(Long id) {
		List<ClassEntity> result = classRepository.findByStudentId(id);
		return result.size();
	}
	
	@Override
	public int totalItem(Long id, String name) {
		List<ClassEntity> result = classRepository.findByStudentId(name, id);
		return result.size();
	}

	@Override
	public List<ClassDTO> findByStudentId(Long id, int page, int limit, String name) {
		List<ClassEntity> classroomEntities = classRepository.findByStudentId(name, id, page, limit);
		List<ClassDTO> classrooms = new ArrayList<>();
		for(ClassEntity item: classroomEntities) {
			ClassDTO classDTO = classConverter.toDTO(item);
			classDTO.setTeacherName(item.getTeacher().getName());
			classrooms.add(classDTO);
		}
		return classrooms;
	}

	@Override
	public void joinClass(Long id_class, Long id_student) {
		Optional<ClassEntity> classEntity = classRepository.findById(id_class);
		Optional<UserEntity> student = userRepository.findById(id_student);
		classEntity.get().getStudents().add(student.get());
		student.get().getClasses().add(classEntity.get());
		classRepository.save(classEntity.get());
	}

	@Override
	public List<ClassDTO> findJoinedClassByStudentId(Long id_student) {
		List<ClassEntity> classEntities = classRepository.findJoinedClassByStudentId(id_student);
		List<ClassDTO> result = new ArrayList<>();
		classEntities.forEach(item -> {
			ClassDTO classDTO = classConverter.toDTO(item);
			classDTO.setTeacherName(item.getTeacher().getName());
			result.add(classDTO);
		});
		return result;
	}
	

}
