package io.magentys.training.ncp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import io.magentys.training.ncp.config.WebConfig;
import io.magentys.training.ncp.service.impl.MiniTwitService;

@Configuration
@ComponentScan({ "io.magentys.training.ncp" })
public class App {
	
	public static void main(String[] args) {
    	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(App.class);
    	new WebConfig(ctx.getBean(MiniTwitService.class));
        ctx.registerShutdownHook();
    }
    
    
}
