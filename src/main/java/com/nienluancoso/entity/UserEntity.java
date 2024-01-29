package com.nienluancoso.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
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
@Table(name = "user")
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	private String email = "";
	private String adress = "";
	private String phone = "";
	private Date birthday = new Date();
	private boolean gender = true;
	private String password;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id")
	private RoleEntity role;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher", orphanRemoval = true)
	private List<ClassEntity> classrooms = new ArrayList<>();
	
	@ManyToMany(mappedBy = "students")
	private Set<ClassEntity> classes = new HashSet<>();

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "student", orphanRemoval = true)
	private List<ImplementationEntity> implementations = new ArrayList<>();

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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
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

	public RoleEntity getRole() {
		return role;
	}

	public void setRole(RoleEntity role) {
		this.role = role;
	}

	public List<ClassEntity> getClassrooms() {
		return classrooms;
	}

	public void setClassrooms(List<ClassEntity> classrooms) {
		this.classrooms = classrooms;
	}

	public Set<ClassEntity> getClasses() {
		return classes;
	}

	public void setClasses(Set<ClassEntity> classes) {
		this.classes = classes;
	}

	public List<ImplementationEntity> getImplementations() {
		return implementations;
	}

	public void setImplementations(List<ImplementationEntity> implementations) {
		this.implementations = implementations;
	}

	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserEntity(long id, String name, String email, String adress, String phone, Date birthday, boolean gender,
			String password, RoleEntity role, List<ClassEntity> classrooms, Set<ClassEntity> classes,
			List<ImplementationEntity> implementations) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.adress = adress;
		this.phone = phone;
		this.birthday = birthday;
		this.gender = gender;
		this.password = password;
		this.role = role;
		this.classrooms = classrooms;
		this.classes = classes;
		this.implementations = implementations;
	}

	
}
