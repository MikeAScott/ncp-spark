package io.magentys.training.ncp.model;

import io.magentys.mvc.authentication.model.User;

public class LoginResult {
	
	private String error;
	
	private User user;
	
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

}
