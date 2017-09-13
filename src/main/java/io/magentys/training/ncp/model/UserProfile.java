package io.magentys.training.ncp.model;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

import io.magentys.mvc.authentication.User;

@Entity("user_profiles")
public class UserProfile {

	@Id
	private ObjectId id;
	
	@Reference
	private User user;
	private List<String> follows = new ArrayList<String>(); 

	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

	public List<String> getFollows() {
		return follows;
	}
	
}
