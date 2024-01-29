package com.nienluancoso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nienluancoso.entity.ExamEntity;

public interface ExamRepository extends JpaRepository<ExamEntity, Long> {
	@Query("SELECT e FROM ExamEntity e INNER JOIN e.classroom c WHERE c.teacher.id = ?1")
	List<ExamEntity> findByTeacherId(Long id);
	
	@Query("SELECT e FROM ExamEntity e WHERE e.classroom.id = ?1 AND e.visibility = true")
	List<ExamEntity> findByClassId(Long id);
	
}
