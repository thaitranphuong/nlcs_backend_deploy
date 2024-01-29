package com.nienluancoso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.nienluancoso.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	@Query("SELECT u FROM UserEntity u WHERE u.email = ?1")
	UserEntity findByEmail(String email);
	
	@Query("SELECT u FROM UserEntity u INNER JOIN u.classes c WHERE c.id = ?1")
	List<UserEntity> findByClassId(Long class_id);
}
