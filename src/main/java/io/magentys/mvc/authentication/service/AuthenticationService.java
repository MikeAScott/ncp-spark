package io.magentys.mvc.authentication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.magentys.mvc.authentication.controllers.PasswordUtil;
import io.magentys.mvc.authentication.dao.UserDao;
import io.magentys.mvc.authentication.model.User;
import io.magentys.training.ncp.model.LoginResult;

@Service
public class AuthenticationService {
	
	private UserDao userDao;
	
	@Autowired
	public AuthenticationService(UserDao userDao) {
		super();
		this.userDao = userDao;
	}
	
	public boolean usernameIsRegistered(String username){
		return getUserbyUsername(username) != null;
	}
	
	public User getUserbyUsername(String username) {
		return userDao.getUserbyUsername(username);
	}
	
	public LoginResult checkUser(User user) {
		LoginResult result = new LoginResult();
		User userFound = userDao.getUserbyUsername(user.getUsername());
		if(userFound == null) {
			result.setError("Invalid username");
		} else if(!PasswordUtil.verifyPassword(user.getPassword(), userFound.getPassword())) {
			result.setError("Invalid password");
		} else {
			result.setUser(userFound);
		}
		
		return result;
	}
	
	public void registerUser(User user) {
		user.setPassword(PasswordUtil.hashPassword(user.getPassword()));
		userDao.registerUser(user);
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
