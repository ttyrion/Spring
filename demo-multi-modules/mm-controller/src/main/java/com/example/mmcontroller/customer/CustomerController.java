package com.example.mmcontroller.customer;

/**
 * @Description:
 * @Date: Created on 15:59 2020/7/28
 */

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.mmdomain.Customer;

@RestController
public class CustomerController {
    @GetMapping("customer/{customerId}")
    public Customer getCustomer(@PathVariable Integer customerId) {
        System.out.println("get customer...");
        Customer c = new Customer();
        c.setId(customerId);
        c.setName("Hello" + customerId);

        return c;
    }
}
