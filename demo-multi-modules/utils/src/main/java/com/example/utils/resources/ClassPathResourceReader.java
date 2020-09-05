package com.example.utils.resources;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Date: Created on 16:43 2020/9/2
 */


public class ClassPathResourceReader {
  private final String path;
  private String content;

  public ClassPathResourceReader(String path) {
    this.path = path;
  }

  public String getContent() {
    if (content == null) {
      try {
        Resource resource = new ClassPathResource(path);
        if (!resource.exists()) {
          return content;
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream(), "UTF-8"));
        content = reader.lines().collect(Collectors.joining("\n"));
        reader.close();
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    }
    return content;
  }
}
