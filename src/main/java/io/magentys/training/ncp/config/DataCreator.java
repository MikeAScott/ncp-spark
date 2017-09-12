package io.magentys.training.ncp.config;

import java.util.Date;

import org.mongodb.morphia.Datastore;

import io.magentys.training.ncp.model.Message;
import io.magentys.training.ncp.model.User;
import io.magentys.training.ncp.util.GravatarUtil;
import io.magentys.training.ncp.util.PasswordUtil;

public class DataCreator {
	
	private Datastore datastore;
	
	public DataCreator(Datastore datastore) {
		this.datastore = datastore;
	}
	
	public void createTestData(){
		datastore.getDB().dropDatabase();
        datastore.ensureIndexes();
        int totalUsers = 10;
        for (int i = 1; i <= 10; i++) {
            User user = createUser(datastore, "User" + i);	
            if (i == 4 || i == 5) {
            	user.getFollows().add("User" + (i + 2));
            	datastore.save(user);
            }
    		createMessages(datastore, user, totalUsers + 1 - i);			
		}
	}

	private void createMessages(Datastore datastore, User user, int count) {
		for (int i = 1; i <= count; i++) {
			Message msg = new Message();
			msg.setUser(user);
			msg.setPubDate(new Date());
			msg.setText("This is message " + i + " written by user " + user.getUsername());
			datastore.save(msg);				
		}
	}

	private User createUser(Datastore datastore, String username) {
        String email = username + "@email.com";
		String gravatar= GravatarUtil.gravatarURL(email,
        		GravatarUtil.GRAVATAR_DEFAULT_IMAGE_TYPE,
        		GravatarUtil.GRAVATAR_SIZE);
        User user = new User();
        user.setUsername(username);
		user.setEmail(email);
        user.setPassword(PasswordUtil.hashPassword("password"));
        user.setGravatar(gravatar);
		datastore.save(user);
		return user;
	}

}
