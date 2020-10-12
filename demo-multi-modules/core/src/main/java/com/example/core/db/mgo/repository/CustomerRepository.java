package com.example.core.db.mgo.repository;

import com.example.mmdomain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @Description:
 * @Date: Created on 15:43 2020/10/7
 */


public interface CustomerRepository extends MongoRepository<Customer, Long> {
  public List<Customer> findByNameIn(List<String> names);
}