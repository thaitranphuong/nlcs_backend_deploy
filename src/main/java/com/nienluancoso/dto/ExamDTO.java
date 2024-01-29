package com.nienluancoso.dto;

public class ExamDTO {
	
	private long id;
	private String name;
	private int time;
	private boolean visibility;
	private Long classroom_id;
	private String classroom_name;
	
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
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public boolean isVisibility() {
		return visibility;
	}
	public void setVisibility(boolean visibility) {
		this.visibility = visibility;
	}
	public Long getClassroom_id() {
		return classroom_id;
	}
	public void setClassroom_id(Long classroom_id) {
		this.classroom_id = classroom_id;
	}
	public String getClassroom_name() {
		return classroom_name;
	}
	public void setClassroom_name(String classroom_name) {
		this.classroom_name = classroom_name;
	}
	
	
}
