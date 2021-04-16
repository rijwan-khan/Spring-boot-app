package com.zensar.dto;

import java.util.List;
import java.util.Set;

public class UserRequest {

	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String email;
	private String pan;
	private Boolean isActive;
	private List<String> role;
	public UserRequest(String username, String password, String firstname, String lastname, String email, String pan,
			Boolean isActive, List<String> role) {
		super();
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.pan = pan;
		this.isActive = isActive;
		this.role = role;
	}
	public UserRequest() {
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
	@Override
	public String toString() {
		return "UserRequest [username=" + username + ", password=" + password + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", email=" + email + ", pan=" + pan + ", isActive=" + isActive + ", role="
				+ role + "]";
	}
	
	
	
}
