package com.example.utils;

/**
* In JUnit 5 the package name has changed and the Assertions are at
 * org.junit.jupiter.api.Assertions and Assumptions at org.junit.jupiter.api.Assumptions
*/
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.utils.resources.ClassPathResourceReader;

/**
* "static import" imports static methods like assertEquals.
*/
import static org.junit.jupiter.api.Assertions.*;

class UtilsApplicationTests {

  @Test
  void contextLoads() {
    System.out.println(">> testing utils.");
  }

  @Test
  void readResource() {
    ClassPathResourceReader reader = new ClassPathResourceReader("test.xml");
    assertEquals(reader.getContent(), "<hello></hello>");
  }
}
