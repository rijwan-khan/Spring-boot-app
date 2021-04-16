package com.zensar.dto;

import java.util.Set;

public class UserResponse {

	private Long id;
	private String username;
	private String firstname;
	private String lastname;
	private String email;
	private String pan;
	private Boolean isActive;
	private Set<String> role;

	public UserResponse(Long id, String username, String firstname, String lastname, String email, String pan,
			Boolean isActive, Set<String> role) {
		super();
		this.id = id;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.pan = pan;
		this.isActive = isActive;
		this.role = role;
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

	public Set<String> getRole() {
		return role;
	}

	public void setRole(Set<String> role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserResponse [id=" + id + ", username=" + username + ", firstname=" + firstname + ", lastname="
				+ lastname + ", email=" + email + ", pan=" + pan + ", isActive=" + isActive + ", role=" + role + "]";
	}

}
