package io.magentys.training.ncp.dao;

import io.magentys.mvc.authentication.User;
import io.magentys.training.ncp.model.UserProfile;

public interface UserProfileDao {

	UserProfile getProfile(User user);
	
	void insertFollower(User follower, User followee);
	
	void deleteFollower(User follower, User followee);
	
	boolean isUserFollower(User follower, User followee);
	
}
