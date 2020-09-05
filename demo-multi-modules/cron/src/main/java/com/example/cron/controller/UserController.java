package com.example.cron.controller;

/**
 * @Description:
 * @Date: Created on 15:16 2020/9/5
 */

import com.example.cron.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
  @GetMapping("/user")
  public User getCustomer() {
    User c = new User();
    c.setId("uid123456");
    c.setName("Jack");

    return c;
  }
}