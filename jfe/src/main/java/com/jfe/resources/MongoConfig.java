/**
 * 
 */
package com.jfe.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;

/**
 * @author Venkatesh
 *
 */
@Configuration
@EnableMongoRepositories(basePackages =  "com.jfe.repository")
@PropertySource("classpath:server.properties")
public class MongoConfig extends AbstractMongoConfiguration {
	
	@Autowired
	private Environment env;
	
	@SuppressWarnings("deprecation")
	@Bean(name = "mongoTemplate")
    public MongoTemplate mongoTemplate() throws Exception {
		String mongoDbHost = env.getProperty("mongo.host");
        int mongoDbPort = Integer.parseInt(env.getProperty("mongo.port"));
        String username = env.getProperty("mongo.username");
        String password = env.getProperty("mongo.password");
		Mongo mongo = new Mongo(mongoDbHost, mongoDbPort);
        UserCredentials userCredentials = new UserCredentials(username, password);
        String databaseName = env.getProperty("mongo.db");
        MongoDbFactory mongoDbFactory = new SimpleMongoDbFactory(mongo, databaseName, userCredentials);
        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory);
        return mongoTemplate;
    }

	@Override
	protected String getDatabaseName() {
		return env.getProperty("mongo.db");
	}

	@SuppressWarnings("deprecation")
	@Override
	public Mongo mongo() throws Exception {
		return new Mongo(env.getProperty("mongo.host"));
	}

}
