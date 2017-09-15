package io.magentys.mvc.authentication.controllers;

import static spark.Spark.before;
import static spark.Spark.get;
import static spark.Spark.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.magentys.mvc.Router;

@Component
public class AuthenticationRoutes implements Router{

	private AuthenticationController authenticationController;

	@Autowired
	public AuthenticationRoutes(AuthenticationController authenticationController) {
		this.authenticationController = authenticationController;
	}
	
	@Override
	public void register(){
		/*
		 * Presents the login form or redirect the user to
		 * her timeline if it's already logged in
		 */
		before("/login", authenticationController::redirectIfLoggedIn);
		get("/login", authenticationController::serveLoginPage);
		post("/login", authenticationController::loginUser);
		
		/*
		 * Presents the register form or redirect the user to
		 * her timeline if it's already logged in
		 */
		before("/register", authenticationController::redirectIfLoggedIn);
		get("/register", authenticationController::serveRegisterPage);
		post("/register", authenticationController::registerUser);

		/*
		 * Logs the user out and redirects to the public timeline
		 */
		get("/logout", authenticationController::logoutUser);

	}
	

}
