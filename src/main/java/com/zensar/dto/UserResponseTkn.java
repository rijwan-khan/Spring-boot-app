package com.zensar.dto;

public class UserResponseTkn {

	private String token;
	private String note;

	public UserResponseTkn() {
		super();
	}

	public UserResponseTkn(String token, String note) {
		super();
		this.token = token;
		this.note = note;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "UserResponseTkn [token=" + token + ", note=" + note + "]";
	}

}
