package io.magentys.training.ncp.controllers;

import static io.magentys.mvc.utils.SessionUtils.*;
import static spark.Spark.halt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.magentys.mvc.View;
import io.magentys.mvc.authentication.model.User;
import io.magentys.mvc.authentication.service.AuthenticationService;
import io.magentys.training.ncp.model.Message;
import io.magentys.training.ncp.service.impl.MiniTwitService;
import io.magentys.training.ncp.view.TimelineView;
import spark.Request;
import spark.Response;

@Component
public class TimelineController {
	
	private MiniTwitService service;
	private AuthenticationService authService;

	@Autowired
	public TimelineController(MiniTwitService service, AuthenticationService authService) {
		this.service = service;
		this.authService = authService;
	}

	public String serveUserTimeline(Request request, Response response) {
		User user = getAuthenticatedUser(request);
		List<Message> messages = service.getUserFullTimelineMessages(user);
		View view = new TimelineView(user, messages);
		return view.render("Timeline");
    }
	
	public void redirectGuestToPublic(Request request, Response response) {
		User user = getAuthenticatedUser(request);
		if(user == null) {
			response.redirect("/public");
			halt();
		}
	}
	
	public String servePublicTimeline(Request request, Response response) {
			User user = getAuthenticatedUser(request);
			List<Message> messages = service.getPublicTimelineMessages();
			View view = new TimelineView(user, messages);
			return view.render("Public Timeline");
	}

	public String serveUserTweets(Request request, Response response) {
		String username = request.params(":username");
		User profileUser = authService.getUserbyUsername(username);
		
		User authUser = getAuthenticatedUser(request);
		boolean followed = false;
		if(authUser != null) {
			followed = service.isUserFollower(authUser, profileUser);
		}
		List<Message> messages = service.getUserTimelineMessages(profileUser);		
		View view = new TimelineView(authUser, messages, profileUser, followed);
		return view.render(username + "'s Timeline");
	}




}
