package io.magentys.mvc.authentication.controllers;

import io.magentys.mvc.authentication.model.User;
import io.magentys.mvc.authentication.service.AuthenticationService;
import io.magentys.mvc.authentication.view.LoginView;
import io.magentys.mvc.authentication.view.RegisterView;
import io.magentys.training.ncp.model.LoginResult;
import spark.Filter;
import spark.Request;
import spark.Response;
import spark.utils.StringUtils;

import static io.magentys.mvc.ViewUtils.*;
import static io.magentys.mvc.authentication.controllers.SessionUtils.*;
import static spark.Spark.halt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AuthenticationController {
	
	private AuthenticationService service;
	
	@Autowired
	public AuthenticationController(AuthenticationService service) {
		this.service = service;
	}

	public void redirectIfNotLoggedOn(Request request, Response response) {
		if(!isAuthenticated(request)) {
			response.redirect("/login");
			halt();
		}
	}

	public void redirectIfLoggedIn(Request request, Response response) {
		if (isAuthenticated(request)) {
			response.redirect("/");
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
		User user = new User();
		populateFromParams(request, user);	
		LoginView view = new LoginView(user);
		
		LoginResult result = service.checkUser(user);
		if(result.getUser() != null) {
			addAuthenticatedUser(request, result.getUser());
			response.redirect("/");
			halt();
		} else {
			view.setError(result.getError());
		}
		return view.render("Sign in");
	}

	public String serveRegisterPage(Request request, Response response) {
		RegisterView view = new RegisterView();
		return view.render("Sign Up");
	}
	
	public String registerUser(Request request, Response response) {
		User user = new User();
		populateFromParams(request, user);

		String error;
		if (service.usernameIsRegistered(user.getUsername())) {
			error = "The username is already taken";
		} else {
			error = user.validate();
		}

		if(StringUtils.isNotEmpty(error)) {
			RegisterView view = new RegisterView(user);
			view.setError(error);
			return view.render("Sign Up");
		}

		service.registerUser(user);
		response.redirect("/login?r=1");
		halt();
		return null;
		
	}

	public Filter logoutUser(Request request, Response response) {
		removeAuthenticatedUser(request);
		response.redirect("/");
		return null;
	}




}
