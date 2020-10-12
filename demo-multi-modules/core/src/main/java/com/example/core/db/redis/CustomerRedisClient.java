package com.example.core.db.redis;

import com.example.mmdomain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Date: Created on 15:36 2020/10/8
 */

@Component
public class CustomerRedisClient {
  private ValueOperations<String, Customer> valueOperations;

  @Autowired
  public void setValueOperations(ValueOperations<String, Customer> valueOperations) {
    this.valueOperations = valueOperations;
  }

  public void setCustomer(Customer c, int expire) {
    valueOperations.set("customer:" + c.getId(), c, expire, TimeUnit.SECONDS);
  }

  public Customer getCustomer(int id) {
    return valueOperations.get("customer:" + id);
  }
}
