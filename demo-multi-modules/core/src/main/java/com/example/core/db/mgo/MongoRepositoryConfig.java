package com.example.core.db.mgo;

import com.example.core.property.MongoDBProperty;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @Description:
 * @Date: Created on 16:06 2020/10/7
 */

@Configuration
@EnableMongoRepositories(basePackages = "com.example.core.db.mgo.repository")
public class MongoRepositoryConfig extends AbstractMongoClientConfiguration {
  private MongoDBProperty mongoDBProperty;

  @Autowired
  public void setEnvConfig(MongoDBProperty mongoDBProperty) {
    this.mongoDBProperty = mongoDBProperty;
  }

  @Override
  protected String getDatabaseName() {
    return  mongoDBProperty.getTestDBName();
  }

  @Override
  public MongoClient mongoClient() {
    ConnectionString connectionString = new ConnectionString(mongoDBProperty.getMongoDBUrl());
    MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
            .applyConnectionString(connectionString)
            .build();

    return MongoClients.create(mongoClientSettings);
  }
}
