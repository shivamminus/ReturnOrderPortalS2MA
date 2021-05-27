package com.returnorder.main.dto;

/*
 * DB Class to store User Credentials
*/

public class AuthenticationRequest {

	private int id;

	private String userName;

	private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AuthenticationRequest(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public AuthenticationRequest() {
		super();
	}

	@Override
	public String toString() {
		return "AuthenticationRequest [id=" + id + ", userName=" + userName + ", password=" + password + "]";
	}

}