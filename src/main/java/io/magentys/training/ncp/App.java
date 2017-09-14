package io.magentys.training.ncp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import io.magentys.mvc.authentication.controllers.AuthenticationController;
import io.magentys.mvc.authentication.controllers.AuthenticationRoutes;
import io.magentys.mvc.authentication.service.AuthenticationService;
import io.magentys.training.ncp.config.AppRoutes;
import io.magentys.training.ncp.config.WebConfig;
import io.magentys.training.ncp.controllers.FollowUserController;
import io.magentys.training.ncp.controllers.MessageController;
import io.magentys.training.ncp.controllers.TimelineController;
import io.magentys.training.ncp.service.impl.MiniTwitService;

@Configuration
@ComponentScan({ "io.magentys.training.ncp" , "io.magentys.mvc.authentication"})
public class App {
	
	public static void main(String[] args) {
    	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(App.class);
    	new WebConfig(
    			ctx.getBean(AuthenticationRoutes.class),
    			ctx.getBean(AppRoutes.class)
    			);
    			
        ctx.registerShutdownHook();
    }
    
    
}
