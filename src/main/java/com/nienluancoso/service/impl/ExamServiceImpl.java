package com.nienluancoso.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nienluancoso.converter.ExamConverter;
import com.nienluancoso.dto.ExamDTO;
import com.nienluancoso.entity.ClassEntity;
import com.nienluancoso.entity.ExamEntity;
import com.nienluancoso.repository.ClassRepository;
import com.nienluancoso.repository.ExamRepository;
import com.nienluancoso.service.ExamService;

@Component
public class ExamServiceImpl implements ExamService {

	@Autowired
	private ExamRepository examRepo;
	
	@Autowired
	private ExamConverter examConverter;
	
	@Autowired
	private ClassRepository classRepo;
	
	@Override
	public Long save(ExamDTO examDTO) {
		ExamEntity result = new ExamEntity();
		if(examDTO.getId() == 0) {
			result = examConverter.toEntity(examDTO);
		} else {
			Optional<ExamEntity> examEntity = examRepo.findById(examDTO.getId());
			result = examConverter.toEntity(examDTO, examEntity.get());
		}
		Optional<ClassEntity> classroom = classRepo.findById(examDTO.getClassroom_id());
		result.setClassroom(classroom.get());
		return examRepo.save(result).getId();
	}

	@Override
	public List<ExamDTO> findByTeacherId(Long id) {
		List<ExamEntity> examEntities = examRepo.findByTeacherId(id);
		List<ExamDTO> result = new ArrayList<>();
		for(ExamEntity item : examEntities) {
			ExamDTO examDTO = examConverter.toDTO(item);
			examDTO.setClassroom_name(item.getClassroom().getName());
			result.add(examDTO);
		}
		return result; 
	}
	
	@Override
	public List<ExamDTO> findByTeacherIdAndName(Long id, String name) {
		List<ExamEntity> examEntities = examRepo.findByTeacherId(id);
		List<ExamDTO> listExamDTO = new ArrayList<>();
		for(ExamEntity item : examEntities) {
			ExamDTO examDTO = examConverter.toDTO(item);
			examDTO.setClassroom_name(item.getClassroom().getName());
			listExamDTO.add(examDTO);
		}
		List<ExamDTO> result = new ArrayList<>();
		for(ExamDTO item : listExamDTO) {
			if(item.getName().toLowerCase().contains(name.toLowerCase())) {
				result.add(item);
			}
		}
		return result; 
	}

	@Override
	public ExamDTO findById(Long id) {
		Optional<ExamEntity> examEntity = examRepo.findById(id);
		ExamDTO result = examConverter.toDTO(examEntity.get());
		ClassEntity classroom = examEntity.get().getClassroom();
		result.setClassroom_name(classroom.getName());
		result.setClassroom_id(classroom.getId());
		return result;
	}

	@Override
	public void deleteById(Long id) {
		examRepo.deleteById(id);
	}

	@Override
	public List<ExamDTO> findByClassId(Long class_id) {
		List<ExamEntity> examEntities = examRepo.findByClassId(class_id);
		List<ExamDTO> result = new ArrayList<>();
		examEntities.forEach(item -> {
			ExamDTO examDTO = examConverter.toDTO(item);
			examDTO.setClassroom_name(item.getClassroom().getName());
			result.add(examDTO);
		});
		return result;
	}


}
