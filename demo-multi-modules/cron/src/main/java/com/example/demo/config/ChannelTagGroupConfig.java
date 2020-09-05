package com.example.demo.config;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * @Description:
 * @Date: Created on 17:31 2020/9/4
 */


public class ChannelTagGroupConfig {
  @JSONField(name="group_place_holder")
  private String groupPlaceHolder;

  @JSONField(name="group")
  private String group;

  @JSONField(name="query_param")
  private String queryParam;

  @JSONField(name="category_id")
  private String categoryId;
}
