package com.example.mmapplication;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-testing
 * Package Error: No qualifying bean of type 'org.springframework.boot.web.context.WebServerApplicationContext' available
 * Reason：By default, @SpringBootTest will not start a server.
 * But: MmApplication启动时需要创建的ApplicationRunner bean依赖了WebServerApplicationContext bean
* */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MmApplicationTests {

    @Test
    void contextLoads() {
    }

}
