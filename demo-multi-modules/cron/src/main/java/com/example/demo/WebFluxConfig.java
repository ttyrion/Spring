package com.example.demo;

/**
 * @Description:
 * @Date: Created on 17:23 2020/9/5
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;

/**
* Prior to Spring 5, RestTemplate has been main technique for client-side HTTP access, which is part of the Spring MVC project.
* Since Spring 5 release, WebClient is the recommended way for such uses.
* Ref: https://howtodoinjava.com/spring-webflux/webclient-get-post-example/
*/

//@Configuration
//@EnableWebFlux
@Component
public class WebFluxConfig implements WebFluxConfigurer {
  @Bean(name = "qipuWebClient")
  public WebClient getWebClient()
  {
    /**
    * We can configure the various timeouts easily at the underlying HTTP client library.
    * It is the most easy and efficient way to configure timeout values globally for the whole application.
    */
    HttpClient httpClient = HttpClient.create()
            .tcpConfiguration(client ->
                    client.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 10000)
                            .doOnConnected(conn -> conn
                                    .addHandlerLast(new ReadTimeoutHandler(10))
                                    .addHandlerLast(new WriteTimeoutHandler(10))));

    // ClientHttpConnector connector = new ReactorClientHttpConnector(httpClient.wiretap(true));
    ClientHttpConnector connector = new ReactorClientHttpConnector(httpClient);

    return WebClient.builder()
            .baseUrl("http://qipu.qiyi.domain")
            .clientConnector(connector)
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .build();
  }
}
