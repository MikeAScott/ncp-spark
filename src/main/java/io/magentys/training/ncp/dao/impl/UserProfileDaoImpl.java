package io.magentys.training.ncp.dao.impl;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import io.magentys.mvc.authentication.model.User;
import io.magentys.training.ncp.dao.UserProfileDao;
import io.magentys.training.ncp.model.UserProfile;

@Repository
public class UserProfileDaoImpl implements UserProfileDao {
	
	private final Datastore datastore;

	@Autowired
	public UserProfileDaoImpl(Datastore datastore) {
		this.datastore = datastore;
	}

	@Override
	public void insertFollower(User follower, User followee) {
		UserProfile profile = getProfile(follower);
		profile.getFollows().add(followee.getUsername());
		datastore.save(profile);
	}

	@Override
	public void deleteFollower(User follower, User followee) {
		UserProfile profile = getProfile(follower);
		profile.getFollows().remove(followee.getUsername());
		datastore.save(profile);		
	}
	
	@Override
	public boolean isUserFollower(User follower, User followee) {
		UserProfile profile = getProfile(follower);
		return profile.getFollows().contains(followee.getUsername());
	}
	
	public UserProfile getProfile(User user) {
		Query<UserProfile> query = datastore.createQuery(UserProfile.class)
			.field("user").equal(user);
		UserProfile profile = query.get();
		if (profile == null ) {
			profile = new UserProfile();
			profile.setUser(user);
		}
		return profile;
	}


}
