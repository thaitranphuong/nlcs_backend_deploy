package com.nienluancoso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nienluancoso.entity.AnswerEntity;


public interface AnswerRepository extends JpaRepository<AnswerEntity, Long> {
	
	@Query("SELECT a FROM AnswerEntity a WHERE a.implementation.id = ?1")
	List<AnswerEntity> findAllByImplementationId(Long id);
}
