package com.nienluancoso.dto;

import java.util.HashSet;
import java.util.Set;
public class ClassDTO {
	private long id;
	
	private String name;
	private String schoolYear;
	private Long teacher_id;
	private String teacherName;
	private Set<Long> students_id = new HashSet<>();
	
	public long getId() {
		return id;
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
	public String getSchoolYear() {
		return schoolYear;
	}
	public void setSchoolYear(String schoolYear) {
		this.schoolYear = schoolYear;
	}
	public Long getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(Long teacher_id) {
		this.teacher_id = teacher_id;
	}
	public Set<Long> getStudents_id() {
		return students_id;
	}
	public void setStudents_id(Set<Long> students_id) {
		this.students_id = students_id;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	
	
}
