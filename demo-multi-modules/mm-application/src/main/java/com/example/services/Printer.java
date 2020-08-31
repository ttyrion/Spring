package com.example.services;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class Printer {
    public void Print(String s) throws InterruptedException {
        System.out.print("On thread:" + Thread.currentThread().getName() + "\n");
        Thread.sleep(1000*3);   // 休眠3秒
        System.out.print(s);
    }

    //Async 在通过this调用此方法时，异步无效：https://my.oschina.net/guangshan/blog/1807721
    @Async
    public void AsyncPrint(String s) throws InterruptedException {
        System.out.print("On thread:" + Thread.currentThread().getName() + "\n");
        Thread.sleep(1000*3);   // 休眠3秒
        System.out.print(s);
    }
}
