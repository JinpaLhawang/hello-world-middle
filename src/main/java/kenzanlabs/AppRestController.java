package kenzanlabs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppRestController {

  private static final Logger log = LoggerFactory.getLogger(AppRestController.class);

  private final String HELLO_WORLD = "Hello World!";

  @RequestMapping("/")
  public String index() {
    log.info(HELLO_WORLD);
    return HELLO_WORLD;
  }

}
