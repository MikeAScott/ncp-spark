package io.magentys.training.ncp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.magentys.mvc.authentication.model.User;
import io.magentys.training.ncp.dao.MessageDao;
import io.magentys.training.ncp.dao.UserProfileDao;
import io.magentys.training.ncp.model.Message;

@Service
public class MiniTwitService {
	
	private UserProfileDao userProfileDao;
	private MessageDao messageDao;
	
	@Autowired
	public MiniTwitService(UserProfileDao userProfileDao, MessageDao messageDao) {
		this.userProfileDao = userProfileDao;
		this.messageDao = messageDao;
	}

	public List<Message> getUserFullTimelineMessages(User user) {
		return messageDao.getUserFullTimelineMessages(user);
	}
	
	public List<Message> getUserTimelineMessages(User user) {
		return messageDao.getUserTimelineMessages(user);
	}
	
	public List<Message> getPublicTimelineMessages() {
		return messageDao.getPublicTimelineMessages();
	}	
	
	public void followUser(User follower, User followee) {
		userProfileDao.insertFollower(follower, followee);
	}
	
	public void unfollowUser(User follower, User followee) {
		userProfileDao.deleteFollower(follower, followee);
	}
	
	public boolean isUserFollower(User follower, User followee) {
		return userProfileDao.isUserFollower(follower, followee);
	}
	
	public void addMessage(Message message) {
		messageDao.insertMessage(message);
	}
	
	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}

}
