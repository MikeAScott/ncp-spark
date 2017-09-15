package io.magentys.mvc.datastore;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mongodb.MongoClient;

import io.magentys.training.ncp.config.DataCreator;


@Configuration
public class DatabaseConfig {

	private static final String AUTHENTICATION_MODELS = "io.magentys.mvc.authentication.model";

	private DbConfig dbConfig;
	@Autowired
	public DatabaseConfig(DbConfig dbConfig){
		this.dbConfig = dbConfig;
	}
	
	@Bean
	public Datastore datastore() {
		final Morphia morphia = new Morphia();
		morphia.getMapper().getOptions().setStoreEmpties(true);
		morphia.mapPackage(AUTHENTICATION_MODELS);
		morphia.mapPackage(dbConfig.modelPackage());
		final Datastore datastore = morphia.createDatastore(new MongoClient(dbConfig.serverAddress()), dbConfig.datastoreName());
		dbConfig.initialize(datastore);
		datastore.ensureIndexes();
		return datastore;	
	}
	

}
