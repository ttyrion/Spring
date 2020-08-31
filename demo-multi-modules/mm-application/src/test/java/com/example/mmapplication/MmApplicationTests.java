package com.example.mmapplication;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.services.Printer;

/**
 * https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-testing
 * Package Error: No qualifying bean of type 'org.springframework.boot.web.context.WebServerApplicationContext' available
 * Reason：By default, @SpringBootTest will not start a server.
 * But: MmApplication启动时需要创建的ApplicationRunner bean依赖了WebServerApplicationContext bean
* */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MmApplicationTests {
    @Autowired
    Printer printer;

    @Test
    void contextLoads() {
    }

    @Test
    public void testAsync() throws InterruptedException {
        System.out.print("...Test...1\n");
        printer.Print("sync hello world.\n");
        System.out.print("...Test...2\n");
        printer.AsyncPrint("async hello world.\n");
        System.out.print("...Test...3\n");
    }
}
