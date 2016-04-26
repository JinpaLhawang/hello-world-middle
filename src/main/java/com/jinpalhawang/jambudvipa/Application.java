package com.jinpalhawang.jambudvipa;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Application {

  private String name;
  private String property;
  private Map<String, String> properties;

  public Application() {}

  public Application(String name, String property, Map<String, String> properties) {
    this.name = name;
    this.property = property;
    this.properties = properties;
  }

  public String getName() {
    return name;
  }

  public String getProperty() {
    return property;
  }

  public Map<String, String> getProperties() {
    return properties;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setProperty(String property) {
    this.property = property;
  }

  public void setProperties(Map<String, String> properties) {
    this.properties = properties;
  }

  @Override
  public String toString() {
    return "[" + name + "] " + property + "; " + properties.size();
  }

}
