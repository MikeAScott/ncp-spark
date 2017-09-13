package io.magentys.training.ncp.controllers;

import static spark.Spark.halt;

import io.magentys.training.ncp.model.User;
import io.magentys.training.ncp.service.impl.MiniTwitService;

import static io.magentys.training.ncp.controllers.SessionUtils.*;

import spark.Request;
import spark.Response;

public class UserController {

	private MiniTwitService service;

	public UserController(MiniTwitService service) {
		this.service = service;
	}
	
	public boolean checkUserExists(Request request, Response response) {
		String username = request.params(":username");
		User profileUser = getUserOrHaltIfNotFound(username);
		return profileUser != null;
	}
	
	public String followUser(Request request, Response response) {
		String username = request.params(":username");
		User profileUser = getUserOrHaltIfNotFound(username);
		User authUser = getAuthenticatedUser(request);		
		service.followUser(authUser, profileUser);
		response.redirect("/t/" + username);
		return null;
	}

	
	public Object unfollowUser(Request request, Response response) {
		String username = request.params(":username");
		User profileUser = getUserOrHaltIfNotFound(username);
		User authUser = getAuthenticatedUser(request);		
		service.unfollowUser(authUser, profileUser);
		response.redirect("/t/" + username);
		return null;
	}

	private User getUserOrHaltIfNotFound(String username) {
		User profileUser = service.getUserbyUsername(username);
		if(profileUser == null) {
			halt(404, "User not Found");
		}
		return profileUser;
	}

	



}
