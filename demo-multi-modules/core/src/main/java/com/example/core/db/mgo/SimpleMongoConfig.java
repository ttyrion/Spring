package com.example.core.db.mgo;

import com.example.core.property.MongoDBProperty;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @Description:
 * @Date: Created on 14:51 2020/10/7
 */


@Configuration
public class SimpleMongoConfig {
  private MongoDBProperty mongoDBProperty;

  @Autowired
  public void setEnvConfig(MongoDBProperty mongoDBProperty) {
    this.mongoDBProperty = mongoDBProperty;
  }

  @Bean
  public MongoClient mongo() {
    ConnectionString connectionString = new ConnectionString(mongoDBProperty.getMongoDBUrl());
    MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
            .applyConnectionString(connectionString)
            .build();

    return MongoClients.create(mongoClientSettings);
  }

  @Bean(name = "testMongoDBTemplate")
  public MongoTemplate getTestMongoTemplate() throws Exception {
    return new MongoTemplate(mongo(), mongoDBProperty.getTestDBName());
  }
}
