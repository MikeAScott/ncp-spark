package io.magentys.mvc.datastore;

import org.mongodb.morphia.Datastore;

import com.mongodb.ServerAddress;

public interface DbConfig {
	
	ServerAddress serverAddress();
	String modelPackage();
	String datastoreName();
	void initialize(Datastore datastore);

}
