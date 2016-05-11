package com.jinpalhawang.jambudvipa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HelloWorldMiddleApplication {

  public static void main(String[] args) {
    SpringApplication.run(HelloWorldMiddleApplication.class, args);
  }

}
