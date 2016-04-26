package com.jinpalhawang.jambudvipa;

import java.net.URI;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class HelloWorldMiddleApplication {

  private static final Logger log = LoggerFactory.getLogger(HelloWorldMiddleApplication.class);

  @Autowired
  private DiscoveryClient discoveryClient;

  @RequestMapping("/")
  public String hello() {
    RestTemplate restTemplate = new RestTemplate();
    URI uri = URI.create("http://localhost:8090/applications/search/findByName?name=hello-world-middle");
    Application application = restTemplate.getForObject(uri, Application.class);
    log.info(application.toString());
    return application.getProperty();
  }

  @RequestMapping("/properties")
  public Map<String, String> properties() {
    RestTemplate restTemplate = new RestTemplate();
    URI uri = URI.create("http://localhost:8090/applications/search/findByName?name=hello-world-middle");
    Application application = restTemplate.getForObject(uri, Application.class);
    log.info(application.toString());
    return application.getProperties();
  }

  @RequestMapping("/service-instances/{applicationName}")
  public List<ServiceInstance> serviceInstancesByApplicationName(@PathVariable String applicationName) {
    return this.discoveryClient.getInstances(applicationName);
  }

  public static void main(String[] args) {
    SpringApplication.run(HelloWorldMiddleApplication.class, args);
  }

}
