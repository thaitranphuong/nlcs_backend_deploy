package com.nienluancoso.dto;

public class AnswerDTO {
	
	private long id;
	private String choice;
	private Long implementation_id;
	private Long question_id;
	private QuestionOptionDTO question;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getChoice() {
		return choice;
	}
	public void setChoice(String choice) {
		this.choice = choice;
	}
	public Long getImplementation_id() {
		return implementation_id;
	}
	public void setImplementation_id(Long implementation_id) {
		this.implementation_id = implementation_id;
	}
	public Long getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(Long question_id) {
		this.question_id = question_id;
	}
	public QuestionOptionDTO getQuestion() {
		return question;
	}
	public void setQuestion(QuestionOptionDTO question) {
		this.question = question;
	}
	
	
}
