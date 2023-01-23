package com.lti.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@Configuration
@Import(value = MongoAutoConfiguration.class)
@EnableMongoRepositories(basePackages = "com.lti")
@EnableAutoConfiguration
public class MongoConfig{
    
    
 
}