package com.zensar.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Table(name = "users")
@Entity
public class User {
	@Id
	@GeneratedValue
	private Long id;
	@Column(name = "username", length = 50, nullable = false, unique = true)
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String email;
	@Column(name = "pan", length = 50, nullable = false, unique = true)
	private String pan;
	private Boolean isActive;
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "roles_tab", joinColumns = @JoinColumn(name = "id"))
	@Column(name = "role")
	private List<String> role;
	public User(Long id, String username, String password, String firstname, String lastname, String email, String pan,
			Boolean isActive, List<String> role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.pan = pan;
		this.isActive = isActive;
		this.role = role;
	}
	public User() {
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public List<String> getRole() {
		return role;
	}
	public void setRole(List<String> role) {
		this.role = role;
	}
	

	

}
