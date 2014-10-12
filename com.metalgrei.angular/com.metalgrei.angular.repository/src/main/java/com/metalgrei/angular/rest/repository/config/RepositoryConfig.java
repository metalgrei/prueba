package com.metalgrei.angular.rest.repository.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

/**
 * The Class RepositoryConfig.
 */
@Configuration
@EnableMongoRepositories
public class RepositoryConfig extends AbstractMongoConfiguration {
	
	/** The Constant DATABASE_NAME. */
	private static final String DATABASE_NAME = "";
	
	/** The Constant MAPPING_BASE_PACKAGE. */
	private static final String MAPPING_BASE_PACKAGE = "com.metalgrei.angular.rest.repository";

	/* (non-Javadoc)
	 * @see org.springframework.data.mongodb.config.AbstractMongoConfiguration#getDatabaseName()
	 */
	@Override
	protected String getDatabaseName() {
		return DATABASE_NAME;
	}

	/* (non-Javadoc)
	 * @see org.springframework.data.mongodb.config.AbstractMongoConfiguration#mongo()
	 */
	@Override
	public Mongo mongo() throws Exception {
		MongoClient result = new MongoClient();
		return result;
	}

	/* (non-Javadoc)
	 * @see org.springframework.data.mongodb.config.AbstractMongoConfiguration#getMappingBasePackage()
	 */
	@Override
	protected final String getMappingBasePackage() {
	    return MAPPING_BASE_PACKAGE;
	  }
}
