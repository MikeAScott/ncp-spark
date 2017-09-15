package io.magentys.training.ncp.controllers;

import static io.magentys.mvc.utils.SessionUtils.*;
import static spark.Spark.halt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.magentys.mvc.authentication.model.User;
import io.magentys.mvc.authentication.service.AuthenticationService;
import io.magentys.training.ncp.service.impl.MiniTwitService;
import spark.Request;
import spark.Response;

@Component
public class FollowUserController {

	private MiniTwitService service;
	private AuthenticationService authService;

	@Autowired
	public FollowUserController(MiniTwitService service, AuthenticationService authService) {
		this.service = service;
		this.authService = authService;
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
		User profileUser = authService.getUserbyUsername(username);
		if(profileUser == null) {
			halt(404, "User not Found");
		}
		return profileUser;
	}

	



}
