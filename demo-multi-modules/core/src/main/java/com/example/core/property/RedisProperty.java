package com.example.core.property;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @Description:
 * @Date: Created on 11:15 2020/10/8
 */

@Configuration
public class RedisProperty {

  @Value("${redis.customer.host:127.0.0.1}")
  private String customerRedisHostName;

  @Value("${redis.customer.port:6379}")
  private int customerRedisPort;

  @Value("${redis.customer.db:1}")
  private int customerRedisDB;

  @Value("${redis.customer.password:}")
  private String customerRedisPassword;

  @Value("${redis.customer.expired:3600}")
  private int customerCacheTTL;

  /**
  * 如果是Redis Cluster, 则配置一个Cluster Node 列表
  * 如：redis.entity.cluster.nodes={'localhost:6379','localhost:6380','localhost:6381'}
  */
  @Value("${redis.customer.cluster.nodes:localhost:8320,localhost:8321}")
  private List<String> customerClusterNodes;

  public String getCustomerRedisHostName() {
    return customerRedisHostName;
  }

  public void setCustomerRedisHostName(String customerRedisHostName) {
    this.customerRedisHostName = customerRedisHostName;
  }

  public int getCustomerRedisPort() {
    return customerRedisPort;
  }

  public void setCustomerRedisPort(int customerRedisPort) {
    this.customerRedisPort = customerRedisPort;
  }

  public int getCustomerRedisDB() {
    return customerRedisDB;
  }

  public void setCustomerRedisDB(int customerRedisDB) {
    this.customerRedisDB = customerRedisDB;
  }

  public String getCustomerRedisPassword() {
    return customerRedisPassword;
  }

  public void setCustomerRedisPassword(String customerRedisPassword) {
    this.customerRedisPassword = customerRedisPassword;
  }

  public int getCustomerCacheTTL() {
    return customerCacheTTL;
  }

  public void setCustomerCacheTTL(int customerCacheTTL) {
    this.customerCacheTTL = customerCacheTTL;
  }

  public List<String> getCustomerClusterNodes() {
    return customerClusterNodes;
  }

  public void setCustomerClusterNodes(List<String> customerClusterNodes) {
    this.customerClusterNodes = customerClusterNodes;

    for (String node : customerClusterNodes) {
      System.out.println("NODE::::::::::::::" + node);
    }
  }
}