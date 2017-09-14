package io.magentys.mvc.authentication.controllers;

import io.magentys.mvc.authentication.model.User;
import spark.Request;

public class SessionUtils {
	
	private static final String USER_SESSION_ID = "user";	
	
	public static boolean isAuthenticated(Request request) {
		return getAuthenticatedUser(request) != null;
	}
	
	public static User getAuthenticatedUser(Request request) {
		return request.session().attribute(USER_SESSION_ID);
	}

	public static void addAuthenticatedUser(Request request, User u) {
		request.session().attribute(USER_SESSION_ID, u);
	}

	public static void removeAuthenticatedUser(Request request) {
		request.session().removeAttribute(USER_SESSION_ID);		
	}


}
