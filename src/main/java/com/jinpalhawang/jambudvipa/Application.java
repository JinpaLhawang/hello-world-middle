package com.jinpalhawang.jambudvipa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Application {

  private String id;
  private String name;
  private String property;

  public Application() {}

  public Application(String id, String name, String property) {
    this.id = id;
    this.name = name;
    this.property = property;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getProperty() {
    return property;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setProperty(String property) {
    this.property = property;
  }

}
