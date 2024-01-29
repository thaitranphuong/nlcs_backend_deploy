package com.nienluancoso.dto;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class UserDTO {
	private long id;
	
	private String name = "";
	private String email = "";
	private String adress = "";
	private String phone = "";
	private String birthday;
	private boolean gender = true;
	private String password = "";
	
	private Long role_id;
	private Set<Long> classroom_id = new HashSet<>();

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		this.birthday = formatter.format(birthday);
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getRole_id() {
		return role_id;
	}

	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}

	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Set<Long> getClassroom_id() {
		return classroom_id;
	}

	public void setClassroom_id(Set<Long> classroom_id) {
		this.classroom_id = classroom_id;
	}
	
}
