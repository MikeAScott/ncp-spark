package io.magentys.training.ncp.config;

import static spark.Spark.before;
import static spark.Spark.get;
import static spark.Spark.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.magentys.mvc.Routes;
import io.magentys.mvc.authentication.controllers.AuthenticationController;
import io.magentys.training.ncp.controllers.FollowUserController;
import io.magentys.training.ncp.controllers.MessageController;
import io.magentys.training.ncp.controllers.TimelineController;

@Component
public class AppRoutes implements Routes {

	private AuthenticationController authenticationController;
	private TimelineController timelineController;
	private FollowUserController userController;
	private MessageController messageController;

	@Autowired
	public AppRoutes(
			AuthenticationController authenticationController,
			TimelineController timelineController, 
			FollowUserController userController,
			MessageController messageController) {
		this.authenticationController = authenticationController;
		this.timelineController = timelineController;
		this.userController = userController;
		this.messageController = messageController;
	}

	@Override
	public void register() {
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
		 * Registers a new message for the user.
		 */
		before("/message", authenticationController::redirectIfNotLoggedOn);
		post("/message", messageController::postMessage);
	}
	
	

}
