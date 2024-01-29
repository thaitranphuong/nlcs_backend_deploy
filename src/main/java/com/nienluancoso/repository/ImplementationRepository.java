package com.nienluancoso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nienluancoso.entity.ImplementationEntity;

public interface ImplementationRepository extends JpaRepository<ImplementationEntity, Long> {
	@Query("SELECT i FROM ImplementationEntity i WHERE i.exam.id = ?1")
	List<ImplementationEntity> findByExamId(Long id);
	
	@Query("SELECT i FROM ImplementationEntity i WHERE i.exam.id = ?1 AND i.student.id = ?2")
	List<ImplementationEntity> findByExamIdAndStudentId(Long exam_id, Long student_id);
	
}
