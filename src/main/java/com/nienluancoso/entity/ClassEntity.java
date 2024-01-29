package com.nienluancoso.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "class")
public class ClassEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	
	@Column(name = "school_year")
	private String schoolYear;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "teacher_id")
	private UserEntity teacher;
	

	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "student_class",
				joinColumns = @JoinColumn(name = "class_id"),
				inverseJoinColumns = @JoinColumn(name = "student_id"))
	private Set<UserEntity> students = new HashSet<>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "classroom", orphanRemoval = true)
	private List<ExamEntity> exams = new ArrayList<>();

	public long getId() {
		return id;
	}

	public String getSchoolYear() {
		return schoolYear;
	}

	public void setSchoolYear(String schoolYear) {
		this.schoolYear = schoolYear;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UserEntity getTeacher() {
		return teacher;
	}

	public void setTeacher(UserEntity teacher) {
		this.teacher = teacher;
	}

	public Set<UserEntity> getStudents() {
		return students;
	}

	public void setStudents(Set<UserEntity> students) {
		this.students = students;
	}

	public List<ExamEntity> getExams() {
		return exams;
	}

	public void setExams(List<ExamEntity> exams) {
		this.exams = exams;
	}
}
