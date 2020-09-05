package com.example.demo;

import com.example.demo.context.ApplicationContextProxy;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @Description:
 * @Date: Created on 16:24 2020/9/4
 */


public abstract class SchedulingTask {
  public abstract void run();
}
