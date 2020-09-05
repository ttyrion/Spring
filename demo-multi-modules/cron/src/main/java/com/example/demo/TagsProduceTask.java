package com.example.demo;

import com.example.demo.config.ChannelTagGroupConfig;
import com.example.demo.context.ApplicationContextProxy;
import com.example.utils.resources.ClassPathResourceReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.alibaba.fastjson.JSON;
import java.util.List;

/**
 * @Description: 片库标签生产
 * @Date: Created on 15:10 2020/9/2
 */
@Component
public class TagsProduceTask extends SchedulingTask {
  private TagsProducer producer;

  @Autowired
  public TagsProduceTask(TagsProducer producer) {
    this.producer = producer;
  }

  @Override
  @Scheduled(fixedRate = 20000)
  public void run() {
    ClassPathResourceReader resReader = new ClassPathResourceReader("config/tags/tag_channel_dianshiju.json");
    String content = resReader.getContent();
    if (content == null || content.isEmpty()) {
      System.out.println("TagsProduceTask get resource failed:" + content);
      return;
    }

    List<ChannelTagGroupConfig> config = JSON.parseArray(content, ChannelTagGroupConfig.class);
    System.out.println(config);

    this.producer.getCategoryGroupsTags(config, 2);
  }
}
