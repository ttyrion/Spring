package com.example.cron;

/**
 * @Description:
 * @Date: Created on 14:31 2020/8/28
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import com.example.utils.resources.ClassPathResourceReader;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

@SpringBootApplication(scanBasePackages = "com.example")
// @EnableScheduling
public class SchedulingTasksApplication {

    public static void main(String[] args) {
        System.out.println("Service Starting...");

        SpringApplication.run(SchedulingTasksApplication.class);
    }

    // webflux（没有WebMvcConfigurer）不支持替换HttpMessageConverters
    /**
     * 使用@Bean注解注入第三方的解析框架fastJson,替换Spring Boot默认的Jackson框架
     *
     */
//    @Bean
//    public HttpMessageConverters fastJsonHttpMessageConverters(){
//        // 1、首先需要先定义一个convert转换消息对象
//        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
//        // 2、添加fastJson的配置信息，比如：是否要格式化返回的json数据
//        FastJsonConfig fastJsonConfig = new FastJsonConfig();
//        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
//        // 3、在convert中添加配置信息
//        fastConverter.setFastJsonConfig(fastJsonConfig);
//        HttpMessageConverter<?> converter = fastConverter;
//        return new HttpMessageConverters(converter);
//    }
}