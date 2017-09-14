package io.magentys.training.ncp.config;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mongodb.MongoClient;


@Configuration
public class DatabaseConfig {

	private static final String AUTHENTICATION_MODELS = "io.magentys.mvc.authentication.model";
	private static final String APP_MODELS = "io.magentys.training.ncp.model";
	private static final String DATASTORE = "no_change_parking";

	@Bean
	public Datastore datastore() {
		final Morphia morphia = new Morphia();
		morphia.getMapper().getOptions().setStoreEmpties(true);
		morphia.mapPackage(AUTHENTICATION_MODELS);
		morphia.mapPackage(APP_MODELS);
		// create the Datastore connecting to the default port on the local host
		final Datastore datastore = morphia.createDatastore(new MongoClient(), DATASTORE);
		new DataCreator(datastore).createTestData();;
		datastore.ensureIndexes();
		return datastore;	
	}
	

}
