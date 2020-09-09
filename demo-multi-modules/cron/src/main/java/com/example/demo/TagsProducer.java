package com.example.demo;

import com.example.demo.config.ChannelTagGroupConfig;
import com.example.demo.context.ApplicationContextProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Date: Created on 16:41 2020/9/5
 */

/**
 * @Description: 三级分类标签数据
 */
class Tag {
  /**
  * 标签标题
  */
  public String text;

  /**
  * 标签在二级分类Group下的排序
  */
  public int order;
}

/**
 * @Description: 二级分类标签数据
 */
class CategoryTags {
  /**
  * 二级分类标签ID
  */
  public int categoryId;
  /**
  * 二级分类标签下的三级分类标签列表
  */
  public ArrayList<Tag> tags;
}

/**
 * @Description: 根据二级分类ID，生产频道的三级分类标签数据
 */
@Component
public class TagsProducer {
  /**
   * IDEA提示：Field injection is not recommended
   * IDEA的策略：Always use constructor based dependency injection in your beans.
   *           Always use assertions for mandatory dependencies
   * @Autowired可以作用于三处地方：类字段、构造方法、set方法；
   * 对应于三种依赖注入方式：变量（field）注入、构造器注入、set方法注入。
   */
  // @Autowired
  private ApplicationContextProxy applicationContextProxy;

  @Autowired
  public TagsProducer(ApplicationContextProxy applicationContextProxy) {
    this.applicationContextProxy = applicationContextProxy;
  }

  protected ApplicationContextProxy getApplicationContextProxy() {
    return this.applicationContextProxy;
  }

  /**
   * @Description:
   * @param groups : 频道二级分类配置列表
   * @param channelId : 频道ID
   * @Return com.example.demo.CategoryTags
   */
  public CategoryTags getCategoryGroupsTags(List<ChannelTagGroupConfig> groups, int channelId) {
    WebClient webClient = (WebClient)getApplicationContextProxy().getBean("qipuWebClient");
    Mono<String> resp = webClient.get()
            .uri("/")
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .retrieve()
            .bodyToMono(String.class);
    String data = resp.block();
    System.out.print("请求的数据：" + data);

    return new CategoryTags();
  }
}
