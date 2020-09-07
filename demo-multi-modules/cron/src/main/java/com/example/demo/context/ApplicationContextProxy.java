package com.example.demo.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Description: 获取Spring上下文对象
 * @Date: Created on 19:52 2020/9/5
 * Note: ApplicationContextProxy 类上的@Component注解是不可以去掉的，
 * 去掉后Spring就不会自动创建该组件，也就不会自动调用setApplicationContext方法来为我们设置上下文实例。
 */
@Component
public class ApplicationContextProxy implements ApplicationContextAware {
  private ApplicationContext applicationContext;

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    this.applicationContext = applicationContext;
  }

  protected ApplicationContext getApplicationContext() {
    return this.applicationContext;
  }

  public Object getBean(String name) {
    return getApplicationContext().getBean(name);
  }

  public <T> T getBean(Class<T> clazz) {
    return getApplicationContext().getBean(clazz);
  }

  public <T> T getBean(String name,Class<T> clazz){
    return getApplicationContext().getBean(name, clazz);
  }
}
