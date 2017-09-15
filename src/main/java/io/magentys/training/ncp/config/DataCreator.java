package io.magentys.training.ncp.config;

import java.util.Date;

import org.mongodb.morphia.Datastore;

import io.magentys.mvc.authentication.controllers.GravatarUtil;
import io.magentys.mvc.authentication.controllers.PasswordUtil;
import io.magentys.mvc.authentication.model.User;
import io.magentys.training.ncp.model.Message;
import io.magentys.training.ncp.model.UserProfile;

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
            User user = createUser("User" + i);	
            if (i == 4 || i == 5) {
            	addFollows(user,"User" + (i + 2));
            }
    		createMessages(user, totalUsers + 1 - i);			
		}
	}
	
	private void addFollows(User user, String followee){
		UserProfile profile = new UserProfile();
		profile.setUser(user);
		profile.getFollows().add(followee);
		datastore.save(profile);
	}

	private void createMessages(User user, int count) {
		for (int i = 1; i <= count; i++) {
			Message msg = new Message();
			msg.setUser(user);
			msg.setPubDate(new Date());
			msg.setText("This is message " + i + " written by user " + user.getUsername());
			datastore.save(msg);				
		}
	}

	private User createUser(String username) {
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
