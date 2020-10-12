package com.example.core.db.redis.config;

import com.example.core.property.RedisProperty;
import com.example.mmdomain.Customer;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

import java.util.List;

/**
 * @Description:
 * @Date: Created on 11:12 2020/10/8
 */

@Component
public class SimpleRedisConfig {
  private RedisProperty redisProperty;

  @Autowired
  public void setCoreConfig(RedisProperty redisProperty) {
    this.redisProperty = redisProperty;
  }

  /**
   * Redis Master-Slave Connection
   */
  @Primary
  @Bean(name = "CustomerLettuceConnectionFactory")
  LettuceConnectionFactory getCustomerLettuceConnectionFactory() {
    /**
     * these methods have been deprecated.
     * We now need to configure using RedisStandaloneConfiguration
     */
//    factory.setHostName(redisHost);
//    factory.setPort(redisPort);

    RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration(
            redisProperty.getCustomerRedisHostName(),
            redisProperty.getCustomerRedisPort());
    String password = redisProperty.getCustomerRedisPassword();
    if (!StringUtils.isEmpty(password)) {
      redisStandaloneConfiguration.setPassword(RedisPassword.of(password));
    }
    redisStandaloneConfiguration.setDatabase(redisProperty.getCustomerRedisDB());
    LettuceConnectionFactory factory = new LettuceConnectionFactory(redisStandaloneConfiguration);

    return factory;
  }

  /**
   * Redis Cluster Connection
   */
  @Bean(name = "CustomerClusterLettuceConnectionFactory")
  LettuceConnectionFactory getCustomerClusterLettuceConnectionFactory() {
    List<String> clusterNodes = redisProperty.getCustomerClusterNodes();
    RedisClusterConfiguration redisClusterConfiguration = new RedisClusterConfiguration(clusterNodes);
    String password = redisProperty.getCustomerRedisPassword();
    if (!StringUtils.isEmpty(password)) {
      redisClusterConfiguration.setPassword(RedisPassword.of(password));
    }
    // TODO:
    // redisClusterConfiguration.setMaxRedirects();
    LettuceConnectionFactory factory = new LettuceConnectionFactory(redisClusterConfiguration);

    return factory;
  }

  /**
   * RedisAutoConfiguration:
   * @ConditionalOnMissingBean(
   *     name = {"redisTemplate"}
   *   )
   */
  @Bean(name = "redisTemplate")
  RedisTemplate< String, Customer> getCustomerRedisTemplate(@Qualifier("CustomerLettuceConnectionFactory") LettuceConnectionFactory lettuceConnectionFactory) {
    final RedisTemplate<String, Customer> template =  new RedisTemplate<>();
    template.setConnectionFactory(lettuceConnectionFactory);

    /**
     * 使用Jackson2JsonRedisSerializer来序列化和反序列化value（默认使用JDK的序列化方式）
     */
    Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Customer.class);
    ObjectMapper om = new ObjectMapper();

    /**
     * 指定要序列化的域，field,get和set,以及修饰符范围，ANY是都有包括private和public
     */
    om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.PUBLIC_ONLY);

    /**
     * 指定序列化输入的类型，类必须是非final修饰的，final修饰的类，比如String,Integer等会跑出异常
     */
    om.activateDefaultTyping(LaissezFaireSubTypeValidator.instance ,
            ObjectMapper.DefaultTyping.NON_FINAL,
            JsonTypeInfo.As.WRAPPER_ARRAY);
    jackson2JsonRedisSerializer.setObjectMapper(om);
    template.setValueSerializer(jackson2JsonRedisSerializer);
    template.setKeySerializer(new StringRedisSerializer() );
    template.setHashKeySerializer(new StringRedisSerializer());
    template.setHashValueSerializer(jackson2JsonRedisSerializer);

    return template;
  }

  /**
   * 对redis字符串类型数据操作
   *
   * @param redisTemplate
   * @return
   */
  @Bean
  public ValueOperations<String, Customer> getEntityValueOperations(@Qualifier("redisTemplate") RedisTemplate<String, Customer> redisTemplate) {
    return redisTemplate.opsForValue();
  }
}
