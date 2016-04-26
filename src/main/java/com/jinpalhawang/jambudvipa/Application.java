package com.jinpalhawang.jambudvipa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Application {

  private String name;
  private String property;

  public Application() {}

  public Application(String name, String property) {
    this.name = name;
    this.property = property;
  }

  public String getName() {
    return name;
  }

  public String getProperty() {
    return property;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setProperty(String property) {
    this.property = property;
  }

  @Override
  public String toString() {
    return "[" + this.name + "] " + this.property;
  }

}
