package com.nienluancoso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nienluancoso.entity.ClassEntity;

public interface ClassRepository extends JpaRepository<ClassEntity, Long> {
	@Query("SELECT c FROM ClassEntity c INNER JOIN c.teacher t WHERE t.id = ?1")
	List<ClassEntity> findByTeacherid(Long teacher_id);
	
	@Query(value = "SELECT * FROM class c where c.id not in "
			+ "(SELECT c.id FROM class c LEFT JOIN student_class sc "
			+ "ON c.id = sc.class_id Where sc.student_id = ?1)",
				nativeQuery = true)
	List<ClassEntity> findByStudentId(Long student_id);
	
	@Query(value = "SELECT * FROM class c where c.id not in "
			+ "(SELECT c.id FROM class c LEFT JOIN student_class sc "
			+ "ON c.id = sc.class_id Where sc.student_id = ?2) AND c.name LIKE %?1%",
				nativeQuery = true)
	List<ClassEntity> findByStudentId(String name, Long student_id);
	
	@Query(value = "SELECT * FROM class c where c.id not in "
			+ "(SELECT c.id FROM class c LEFT JOIN student_class sc "
			+ "ON c.id = sc.class_id Where sc.student_id = ?1) LIMIT ?3 OFFSET ?2",
				nativeQuery = true)
	List<ClassEntity> findByStudentId(Long student_id, int page, int limit);
	
	@Query(value = "SELECT * FROM class c where c.id not in "
			+ "(SELECT c.id FROM class c LEFT JOIN student_class sc "
			+ "ON c.id = sc.class_id Where sc.student_id = ?2) AND c.name LIKE %?1% LIMIT ?4 OFFSET ?3",
				nativeQuery = true)
	List<ClassEntity> findByStudentId(String name, Long student_id, int page, int limit);
	
	@Query(value = "SELECT * FROM class c LEFT JOIN student_class sc "
			+ "ON c.id = sc.class_id Where sc.student_id = ?1",
				nativeQuery = true)
	List<ClassEntity> findJoinedClassByStudentId(Long student_id);
}
