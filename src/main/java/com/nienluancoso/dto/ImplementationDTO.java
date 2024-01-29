package com.nienluancoso.dto;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ImplementationDTO {
	
	private long id;
	private float score;
	private String date;
	private Long student_id;
	private Long exam_id;
	private List<AnswerDTO> answers = new ArrayList<>();
	
	private String student_name;
	private String exam_name;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public String getDate() {
		return date;
	}

	public void setDate(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss dd/MM/yyyy");
		this.date = formatter.format(date);
	}

	public Long getStudent_id() {
		return student_id;
	}

	public void setStudent_id(Long student_id) {
		this.student_id = student_id;
	}

	public Long getExam_id() {
		return exam_id;
	}

	public void setExam_id(Long exam_id) {
		this.exam_id = exam_id;
	}

	public List<AnswerDTO> getAnswers() {
		return answers;
	}

	public void setAnswers(List<AnswerDTO> answers) {
		this.answers = answers;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public String getExam_name() {
		return exam_name;
	}

	public void setExam_name(String exam_name) {
		this.exam_name = exam_name;
	}
	
	
}
