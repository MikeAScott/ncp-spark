package io.magentys.mvc.authentication.dao;

import io.magentys.mvc.authentication.model.User;

public interface UserDao {

	User getUserbyUsername(String username);
	
	void registerUser(User user);
}
