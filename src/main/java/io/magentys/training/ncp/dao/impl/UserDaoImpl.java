package io.magentys.training.ncp.dao.impl;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.mapping.Mapper;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import io.magentys.training.ncp.dao.UserDao;
import io.magentys.training.ncp.model.User;
import io.magentys.training.ncp.util.GravatarUtil;

@Repository
public class UserDaoImpl implements UserDao {
	
	private Datastore datastore;
	@Autowired
	public UserDaoImpl(Datastore datastore) {
		this.datastore = datastore;
	}

	@Override
	public User getUserbyUsername(String username) {
		Query<User> query = datastore.createQuery(User.class)
				.filter("username =", username);
		return query.get();
	}

	@Override
	public void insertFollower(User follower, User followee) {
		Query<User> query = datastore.createQuery(User.class)
			.field(Mapper.ID_KEY).equal(follower.getId());
		UpdateOperations<User> ops = datastore.createUpdateOperations(User.class)
			.add("follows", followee.getUsername());
		datastore.update(query, ops);
	}

	@Override
	public void deleteFollower(User follower, User followee) {
		Query<User> query = datastore.createQuery(User.class)
				.field(Mapper.ID_KEY).equal(follower.getId());
			UpdateOperations<User> ops = datastore.createUpdateOperations(User.class)
				.removeAll("follows", followee.getUsername());
			datastore.update(query, ops);
	}
	
	@Override
	public boolean isUserFollower(User follower, User followee) {
		Query<User> query = datastore.createQuery(User.class)
				.field(Mapper.ID_KEY).equal(follower.getId())
				.field("follows").contains(followee.getUsername());
		return query.countAll() > 0;
	}

	@Override
	public void registerUser(User user) {
		user.setGravatar(GravatarUtil.gravatarURL(user.getEmail(),
				GravatarUtil.GRAVATAR_DEFAULT_IMAGE_TYPE,
				GravatarUtil.GRAVATAR_SIZE));		
		datastore.save(user);
	}

}
