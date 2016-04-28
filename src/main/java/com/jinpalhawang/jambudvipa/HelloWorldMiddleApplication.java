package com.jinpalhawang.jambudvipa;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class HelloWorldMiddleApplication {

  @Autowired
  void setEnvironment(Environment e) {
    System.out.println(e.getProperty("helloWorld"));
  }

  public static void main(String[] args) {
    SpringApplication.run(HelloWorldMiddleApplication.class, args);
  }

}

@RestController
@RefreshScope
class FooRestController {

  private static final Logger log = LoggerFactory.getLogger(HelloWorldMiddleApplication.class);

  @Autowired
  private DiscoveryClient discoveryClient;

  @Value("${helloWorld}")
  private String helloWorld;

  @RequestMapping("/")
  public String helloWorld() {
    RestTemplate restTemplate = new RestTemplate();
    URI uri = URI.create("http://localhost:8090/accounts/search/findByFirstName?firstName=Jinpa");
    Account account = restTemplate.getForObject(uri, Account.class);
    log.info(account.toString());
    String response = helloWorld.replace("World", account.getFirstName() + " " + account.getLastName());
    log.info(response);
    return response;
  }

  @RequestMapping("/service-instances/{applicationName}")
  public List<ServiceInstance> serviceInstancesByApplicationName(@PathVariable String applicationName) {
    return this.discoveryClient.getInstances(applicationName);
  }

}