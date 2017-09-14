package io.magentys.training.ncp.config;

import static spark.Spark.staticFileLocation;

import org.springframework.beans.factory.annotation.Autowired;

import io.magentys.mvc.authentication.controllers.AuthenticationRoutes;

public class WebConfig {
	
	@Autowired
	public WebConfig(AuthenticationRoutes authRoutes,AppRoutes appRoutes){
		staticFileLocation("/public");
		authRoutes.register();
		appRoutes.register();
	}

}
