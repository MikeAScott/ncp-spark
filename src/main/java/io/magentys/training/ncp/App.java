package io.magentys.training.ncp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import io.magentys.mvc.authentication.AuthenticationController;
import io.magentys.mvc.authentication.AuthenticationService;
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
    	//new WebConfig(ctx.getBean(MiniTwitService.class), ctx.getBean(AuthenticationService.class));
    	new WebConfig(
    			ctx.getBean(TimelineController.class),
    			ctx.getBean(FollowUserController.class),
    			ctx.getBean(AuthenticationController.class),
    			ctx.getBean(MessageController.class)
    			);
    			
        ctx.registerShutdownHook();
    }
    
    
}
