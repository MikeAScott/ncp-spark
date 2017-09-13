package io.magentys.mvc.authentication;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
	public void registerUser(User user) {
		user.setGravatar(GravatarUtil.gravatarURL(user.getEmail(),
				GravatarUtil.GRAVATAR_DEFAULT_IMAGE_TYPE,
				GravatarUtil.GRAVATAR_SIZE));		
		datastore.save(user);
	}

}
