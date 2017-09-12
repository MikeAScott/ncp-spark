package io.magentys.training.ncp.controllers;

import static spark.Spark.halt;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.magentys.training.ncp.model.Message;
import io.magentys.training.ncp.model.User;
import io.magentys.training.ncp.service.impl.MiniTwitService;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.freemarker.FreeMarkerEngine;

public class PageController {
	
	private static final String USER_SESSION_ID = "user";	
	private MiniTwitService service;

	public PageController(MiniTwitService service) {
		this.service = service;
	}

	public String serveUserTimeline(Request request, Response response) {
		User user = getAuthenticatedUser(request);
		Map<String, Object> map = new HashMap<>();
		map.put("pageTitle", "Timeline");
		map.put("user", user);
		List<Message> messages = service.getUserFullTimelineMessages(user);
		map.put("messages", messages);
		return render(map, "timeline.ftl");
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
			Map<String, Object> map = new HashMap<>();
			map.put("pageTitle", "Public Timeline");
			map.put("user", user);
			map.put("messages", messages);
			return render(map, "timeline.ftl");
	}

	public String serveUserTweets(Request request, Response response) {
		String username = request.params(":username");
		User profileUser = service.getUserbyUsername(username);
		
		User authUser = getAuthenticatedUser(request);
		boolean followed = false;
		if(authUser != null) {
			followed = service.isUserFollower(authUser, profileUser);
		}
		List<Message> messages = service.getUserTimelineMessages(profileUser);
		
		Map<String, Object> map = new HashMap<>();
		map.put("pageTitle", username + "'s Timeline");
		map.put("user", authUser);
		map.put("profileUser", profileUser);
		map.put("followed", followed);
		map.put("messages", messages);
		return render(map, "timeline.ftl");
	}

	public void checkUserExists(Request request, Response response) {
		String username = request.params(":username");
		User profileUser = service.getUserbyUsername(username);
		if(profileUser == null) {
			halt(404, "User not Found");
		}
	}

	
    public static String render(Map<String, Object> model,String templatePath) {
        return new FreeMarkerEngine().render(new ModelAndView(model, templatePath));
    }
    
	private void addAuthenticatedUser(Request request, User u) {
		request.session().attribute(USER_SESSION_ID, u);
		
	}

	private void removeAuthenticatedUser(Request request) {
		request.session().removeAttribute(USER_SESSION_ID);
		
	}

	private User getAuthenticatedUser(Request request) {
		return request.session().attribute(USER_SESSION_ID);
	}


}
