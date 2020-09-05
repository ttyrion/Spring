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

  /**
   * FastJson在进行操作时，是根据getter和setter的方法进行的，并不是依据Field进行
   * 因此，需要给实体类添加getter & setter(ALT+Insert即可自动添加)
  */
  public String getGroupPlaceHolder() {
    return groupPlaceHolder;
  }

  public void setGroupPlaceHolder(String groupPlaceHolder) {
    this.groupPlaceHolder = groupPlaceHolder;
  }

  public String getGroup() {
    return group;
  }

  public void setGroup(String group) {
    this.group = group;
  }

  public String getQueryParam() {
    return queryParam;
  }

  public void setQueryParam(String queryParam) {
    this.queryParam = queryParam;
  }

  public String getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(String categoryId) {
    this.categoryId = categoryId;
  }

  @JSONField(name="category_id")
  private String categoryId;
}
