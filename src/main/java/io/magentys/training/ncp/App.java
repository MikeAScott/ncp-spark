package io.magentys.training.ncp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import io.magentys.mvc.WebApp;


@Configuration
@ComponentScan({ "io.magentys.training.ncp" , "io.magentys.mvc"})
public class App {
	
	public static void main(String[] args) {
    	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(App.class);
    	WebApp app = ctx.getBean(WebApp.class);
    	app.initialize();
        ctx.registerShutdownHook();
    }
    
    
}
