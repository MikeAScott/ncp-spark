package io.magentys.mvc;

import static spark.Spark.staticFileLocation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebApp {

	List<Router> routes;

	@Autowired
	public WebApp(List<Router> routes){
		this.routes = routes;
	}
	
	public void initialize(){
		staticFileLocation("/public");
		routes.forEach(r -> r.register()); 
	}

}
