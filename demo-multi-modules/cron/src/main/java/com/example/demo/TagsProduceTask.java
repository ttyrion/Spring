package com.example.demo;

import com.example.utils.resources.ClassPathResourceReader;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.alibaba.fastjson.JSON;
import com.example.demo.config.ChannelTagsConfig;

/**
 * @Description: 片库标签生产
 * @Date: Created on 15:10 2020/9/2
 */
@Component
public class TagsProduceTask extends SchedulingTask {
  @Override
  // @Scheduled(fixedRate = 20000)
  public void run() {
    ClassPathResourceReader resReader = new ClassPathResourceReader("config/tags/tag_channel_dianshiju.json");
    String content = resReader.getContent();
    if (content == null || content.isEmpty()) {
      System.out.println("TagsProduceTask get resource failed:" + content);
      return;
    }

    ChannelTagsConfig config = JSON.parseObject(content, ChannelTagsConfig.class);
    System.out.println(config);
  }
}
