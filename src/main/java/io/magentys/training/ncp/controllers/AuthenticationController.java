package io.magentys.training.ncp.controllers;

import io.magentys.training.ncp.model.LoginResult;
import io.magentys.training.ncp.model.User;
import io.magentys.training.ncp.service.impl.MiniTwitService;
import io.magentys.training.ncp.view.LoginView;
import io.magentys.training.ncp.view.RegisterView;
import spark.Filter;
import spark.Request;
import spark.Response;
import spark.utils.StringUtils;

import static spark.Spark.halt;
import static io.magentys.training.ncp.controllers.SessionUtils.*;
import static io.magentys.training.ncp.view.ViewUtils.*;


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
		LoginView view = new LoginView();
		if(request.queryParams("r") != null) {
			view.setMessage("You were successfully registered and can login now");
		}
		return view.render("Sign In");
	}

	public String loginUser(Request request, Response response) {
		LoginView view = new LoginView();
		User user = new User();
		populateFromParams(request, user);		
		LoginResult result = service.checkUser(user);
		if(result.getUser() != null) {
			addAuthenticatedUser(request, result.getUser());
			response.redirect("/");
			halt();
		} else {
			view.setError(result.getError());
		}
		view.setUsername(user.getUsername());
		return view.render("Sign in");
	}

	public void redirectIfLoggedIn(Request request, Response response) {
		User authUser = getAuthenticatedUser(request);
		if(authUser != null) {
			response.redirect("/");
			halt();
		}
	}
	
	public String registerUser(Request request, Response response) {
		RegisterView view = new RegisterView();
		User user = new User();
		populateFromParams(request, user);
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
		view.setError(error);
		view.setUsername(user.getUsername());
		view.setEmail(user.getEmail());
		return view.render("Sign Up");
	}

	/**
	 * Renders the Register User Page
	 * @param request
	 * @param response
	 * @return A string containing the register page
	 */
	public String serveRegisterPage(Request request, Response response) {
		RegisterView view = new RegisterView();
		return view.render("Sign Up");
	}

	public Filter logoutUser(Request request, Response response) {
		removeAuthenticatedUser(request);
		response.redirect("/public");
		return null;
	}




}
