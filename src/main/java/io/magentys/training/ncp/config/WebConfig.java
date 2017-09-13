package io.magentys.training.ncp.config;

import static spark.Spark.before;
import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.staticFileLocation;

import io.magentys.training.ncp.controllers.AuthenticationController;
import io.magentys.training.ncp.controllers.MessageController;
import io.magentys.training.ncp.controllers.TimelineController;
import io.magentys.training.ncp.controllers.UserController;

import io.magentys.training.ncp.service.impl.MiniTwitService;

public class WebConfig {
	
	private TimelineController timelineController;
	private UserController userController;
	private AuthenticationController authenticationController;
	private MessageController messageController;
	

	public WebConfig(MiniTwitService service) {
		staticFileLocation("/public");
		timelineController = new TimelineController(service);
		userController = new UserController(service);
		authenticationController = new AuthenticationController(service);
		messageController = new MessageController(service);
		setupRoutes();
	}
	
	private void setupRoutes() {
		/*
		 * Shows a users timeline or if no user is logged in,
		 *  it will redirect to the public timeline.
		 *  This timeline shows the user's messages as well
		 *  as all the messages of followed users.
		 */
		before("/", timelineController::redirectGuestToPublic);
		get("/", timelineController::serveUserTimeline);

		
		/*
		 * Displays the latest messages of all users.
		 */
		get("/public", timelineController::servePublicTimeline);
		
		
		/*
		 * Adds the current user as follower of the given user.
		 */
		before("/t/:username/follow", authenticationController::redirectIfNotLoggedOn);
		get("/t/:username/follow", userController::followUser);
				
		/*
		 * Removes the current user as follower of the given user.
		 */
		before("/t/:username/unfollow", authenticationController::redirectIfNotLoggedOn);
		get("/t/:username/unfollow", userController::unfollowUser);

		/*
		 * Displays a user's tweets.
		 */
		before("/t/:username", userController::checkUserExists);
		get("/t/:username", timelineController::serveUserTweets);

		
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
		
		/*
		 * Registers a new message for the user.
		 */
		before("/message", authenticationController::redirectIfNotLoggedOn);
		post("/message", messageController::postMessage);
	}

}
