package com.example.mmcontroller.customer;

/**
 * @Description:
 * @Date: Created on 15:59 2020/7/28
 */

import com.example.core.db.mgo.repository.CustomerRepository;
import com.example.core.db.redis.CustomerRedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.mmdomain.Customer;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {

    private MongoTemplate mongoTemplate;
    private CustomerRepository customerRepository;
    private CustomerRedisClient customerRedisClient;

    @Autowired
    public void setMongoTemplate(@Qualifier("testMongoDBTemplate") MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Autowired
    public void setCustomerRedisClient(CustomerRedisClient customerRedisClient) {
        this.customerRedisClient = customerRedisClient;
    }

    @GetMapping("customer/{customerId}")
    public Customer getCustomer(@PathVariable Integer customerId) {
        Customer c = customerRedisClient.getCustomer(customerId);
        if (c == null) {
            c = mongoTemplate.findById(customerId, Customer.class);
            customerRedisClient.setCustomer(c, 300);
        }

        return c;
    }

//    @GetMapping("customer/{customerId}/{customerName}")
//    public Customer getCustomer(
//            @PathVariable Integer customerId,
//            @PathVariable String customerName) {
//
//        Customer c = new Customer();
//        c.setId(customerId);
//        c.setName(customerName);
//        mongoTemplate.insert(c);
//        return c;
//    }

}
