package io.magentys.training.ncp.config;

import org.mongodb.morphia.Datastore;
import org.springframework.context.annotation.Configuration;

import com.mongodb.ServerAddress;

import io.magentys.mvc.datastore.DbConfig;

@Configuration
public class AppDbConfig implements DbConfig {

	@Override
	public ServerAddress serverAddress() {
		return new ServerAddress();
	}
	
	@Override
	public String modelPackage() {
		return "io.magentys.training.ncp.model";
	}

	@Override
	public String datastoreName() {
		return "no_change_parking";
	}

	@Override
	public void initialize(Datastore datastore) {
		new DataCreator(datastore).createTestData();
	}
	

}
