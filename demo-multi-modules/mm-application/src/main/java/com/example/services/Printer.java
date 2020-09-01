package com.example.services;

import com.example.services.LogEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

// @Component
@Configuration
@Import(LogEntity.class)
public class Printer {
    private LogEntity loge_;

    public Printer() {
        loge_ = new LogEntity();
    }

    public LogEntity getLogEntity() {
        System.out.print("Init LogEntity Bean...");
        return new LogEntity();
    }

    @Bean
    public LogEntityWrapper getLogEntityWrapper() {
        return new LogEntityWrapper(getLogEntity());
    }

    public void Print(String s) throws InterruptedException {
        System.out.print("printer " + loge_ + ":" + "On thread:" + Thread.currentThread().getName() + "\n");
        Thread.sleep(1000*3);   // 休眠3秒
        System.out.print("printer " + loge_ + ":" + s);
    }

    //Async 在通过this调用此方法时，异步无效：https://my.oschina.net/guangshan/blog/1807721
    @Async
    public void AsyncPrint(String s) throws InterruptedException {
        System.out.print("printer " + loge_ + ":" + "On thread:" + Thread.currentThread().getName() + "\n");
        Thread.sleep(1000*3);   // 休眠3秒
        System.out.print("printer " + loge_ + ":" + s);
    }
}
