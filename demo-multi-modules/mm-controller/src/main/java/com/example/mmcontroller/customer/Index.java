package com.example.mmcontroller.customer;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Date: Created on 15:58 2020/7/30
 */

@RestController
public class Index {
    @RequestMapping("/")
    public String index(){
        return "OK";
    }
}
