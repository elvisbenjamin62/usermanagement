package com.usermanagement.dto;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.MongoClient;

@Configuration
public class MongoDBConfig {
	
	@Value("${mydatabase.mongodb.db}")
	private String db;
	
	@Value("${mydatabase.mongodb.address}")
	private String address;
	
	
	public @Bean MongoClient mongoClient() {
	      return new MongoClient(address) ;
	  }

	  public @Bean MongoTemplate mongoTemplate() {
	      return new MongoTemplate(mongoClient(), db) ;
	  }
}
