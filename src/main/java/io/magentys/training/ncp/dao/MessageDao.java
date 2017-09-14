package io.magentys.training.ncp.dao;

import java.util.List;

import io.magentys.mvc.authentication.model.User;
import io.magentys.training.ncp.model.Message;

public interface MessageDao {
	List<Message> getUserTimelineMessages(User user);
	
	List<Message> getUserFullTimelineMessages(User user);
	
	List<Message> getPublicTimelineMessages();
	
	void insertMessage(Message m);
}
