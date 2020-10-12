package com.example.core.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Date: Created on 14:51 2020/10/7
 */


@Configuration
public class MongoDBProperty {
  /**
   * MongoDB数据库地址
   */
  @Value( "${mongodb.test.url:mongodb://localhost:27017}" )
  private String mongoDBUrl;

  /**
   * 数据库名
   */
  @Value( "${mongodb.test.db:test}" )
  private String testDBName;

  public String getMongoDBUrl() {
    return mongoDBUrl;
  }

  public void setMongoDBUrl(String mongoDBUrl) {
    this.mongoDBUrl = mongoDBUrl;
  }

  public String getTestDBName() {
    return testDBName;
  }

  public void setTestDBName(String testDBName) {
    this.testDBName = testDBName;
  }
}
