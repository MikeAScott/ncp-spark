package io.magentys.training.ncp.dao.impl;

import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import io.magentys.mvc.authentication.model.User;
import io.magentys.training.ncp.dao.MessageDao;
import io.magentys.training.ncp.dao.UserProfileDao;
import io.magentys.training.ncp.model.Message;
import io.magentys.training.ncp.model.UserProfile;

@Repository
public class MessageDaoImpl implements MessageDao {	

	private Datastore datastore;
	private UserProfileDao userProfileDao;

	@Autowired
	public MessageDaoImpl(Datastore datastore, UserProfileDao userProfileDao) {
		super();
		this.datastore = datastore;
		this.userProfileDao = userProfileDao;
	}

	@Override
	public List<Message> getUserTimelineMessages(User user) {
		Query<Message> query = datastore.createQuery(Message.class)
				.field("user").equal(user)
				.order("-pubDate");
		List<Message> result = query.asList();
		return result;
	}

	@Override
	public List<Message> getUserFullTimelineMessages(User user) {
		UserProfile profile = userProfileDao.getProfile(user);
		Query<Message> query = datastore.createQuery(Message.class);
		query.or(
			 query.criteria("username").equal(user.getUsername())
		    ,query.criteria("username").in(profile.getFollows())
		);
		query.order("-pubDate");
		List<Message> result = query.asList();
		return result;
	}

	@Override
	public List<Message> getPublicTimelineMessages() {
		Query<Message> query = datastore.createQuery(Message.class)
				.order("-pubDate");
		return query.asList();
	}

	@Override
	public void insertMessage(Message m) {
		datastore.save(m);
	}

}
