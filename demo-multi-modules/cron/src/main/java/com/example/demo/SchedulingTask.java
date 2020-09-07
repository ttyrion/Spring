package com.example.demo;

import com.example.demo.context.ApplicationContextProxy;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @Description:
 * @Date: Created on 16:24 2020/9/4
 */


public abstract class SchedulingTask {
  public abstract void run();
  /**
   * abstract method上的注解不能被继承
   */
  // public abstract void run();

  /**
   * @Description: 被Spring调度的方法，禁止子类重写，https://zhuanlan.zhihu.com/p/33083924
   * @Return void
   */
//  @Scheduled
//  protected final void onSched() {
//    run();
//  }


}
