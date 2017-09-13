package io.magentys.mvc.authentication;

public interface UserDao {

	User getUserbyUsername(String username);
	
	void registerUser(User user);
}
