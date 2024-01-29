package com.nienluancoso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nienluancoso.entity.QuestionEntity;

public interface QuestionRepository extends JpaRepository<QuestionEntity, Long> {
	@Query("SELECT a FROM QuestionEntity a Where a.exam.id = ?1")
	List<QuestionEntity> findAllByExamId(Long id);
}
