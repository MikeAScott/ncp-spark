package io.magentys.training.ncp.controllers;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.eclipse.jetty.util.MultiMap;
import org.eclipse.jetty.util.UrlEncoded;

import io.magentys.training.ncp.model.LoginResult;
import io.magentys.training.ncp.model.User;
import io.magentys.training.ncp.service.impl.MiniTwitService;
import spark.Filter;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.utils.StringUtils;

import static spark.Spark.halt;

import static io.magentys.training.ncp.controllers.ViewUtils.*;
import static io.magentys.training.ncp.controllers.SessionUtils.*;


public class AuthenticationController {
	
	private MiniTwitService service;
	
	public AuthenticationController(MiniTwitService service) {
		this.service = service;
	}

	public void redirectIfNotLoggedOn(Request request, Response response) {
		User authUser = getAuthenticatedUser(request);
		if(authUser == null) {
			response.redirect("/login");
			halt();
		}
	}
	
	public String serveLoginPage(Request request, Response response) {
		Map<String, Object> map = new HashMap<>();
		if(request.queryParams("r") != null) {
			map.put("message", "You were successfully registered and can login now");
		}
		return render(map, "login.ftl");
	}

	public String loginUser(Request request, Response response) {
		Map<String, Object> map = new HashMap<>();
		User user = new User();
		try {
			MultiMap<String> params = new MultiMap<String>();
			UrlEncoded.decodeTo(request.body(), params, "UTF-8");
			BeanUtils.populate(user, params);
		} catch (Exception e) {
			halt(501);
			return null;
		}
		LoginResult result = service.checkUser(user);
		if(result.getUser() != null) {
			addAuthenticatedUser(request, result.getUser());
			response.redirect("/");
			halt();
		} else {
			map.put("error", result.getError());
		}
		map.put("username", user.getUsername());
		return render(map, "login.ftl");
	}

	public void redirectIfLoggedIn(Request request, Response response) {
		User authUser = getAuthenticatedUser(request);
		if(authUser != null) {
			response.redirect("/");
			halt();
		}
	}
	
	public ModelAndView registerUser(Request request, Response response) {
		Map<String, Object> map = new HashMap<>();
		User user = new User();
		try {
			MultiMap<String> params = new MultiMap<String>();
			UrlEncoded.decodeTo(request.body(), params, "UTF-8");
			BeanUtils.populate(user, params);
		} catch (Exception e) {
			halt(501);
			return null;
		}
		String error = user.validate();
		if(StringUtils.isEmpty(error)) {
			User existingUser = service.getUserbyUsername(user.getUsername());
			if(existingUser == null) {
				service.registerUser(user);
				response.redirect("/login?r=1");
				halt();
			} else {
				error = "The username is already taken";
			}
		}
		map.put("error", error);
		map.put("username", user.getUsername());
		map.put("email", user.getEmail());
		return new ModelAndView(map, "register.ftl");
	}

	/**
	 * Renders the Register User Page
	 * @param request
	 * @param response
	 * @return A string containing the register page
	 */
	public String serveRegisterPage(Request request, Response response) {
		Map<String, Object> map = new HashMap<>();
		return render(map, "register.ftl");
	}

	public Filter logoutUser(Request request, Response response) {
		removeAuthenticatedUser(request);
		response.redirect("/public");
		return null;
	}



}
