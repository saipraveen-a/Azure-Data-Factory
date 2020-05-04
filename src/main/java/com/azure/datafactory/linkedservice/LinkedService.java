package com.azure.datafactory.linkedservice;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LinkedService {

  @JsonProperty("id")
  private String id;
  @JsonProperty("name")
  private String name;
  @JsonProperty("type")
  private String type;
  @JsonProperty("properties")
  private LinkedServiceProperties properties;
  @JsonProperty("etag")
  private String etag;

  @JsonProperty("id")
  public String getId() {
    return id;
  }

  @JsonProperty("id")
  public void setId(String id) {
    this.id = id;
  }

  public LinkedService withId(String id) {
    this.id = id;
    return this;
  }

  @JsonProperty("name")
  public String getName() {
    return name;
  }

  @JsonProperty("name")
  public void setName(String name) {
    this.name = name;
  }

  public LinkedService withName(String name) {
    this.name = name;
    return this;
  }

  @JsonProperty("type")
  public String getType() {
    return type;
  }

  @JsonProperty("type")
  public void setType(String type) {
    this.type = type;
  }

  public LinkedService withType(String type) {
    this.type = type;
    return this;
  }

  @JsonProperty("properties")
  public LinkedServiceProperties getProperties() {
    return properties;
  }

  @JsonProperty("properties")
  public void setProperties(LinkedServiceProperties properties) {
    this.properties = properties;
  }

  public LinkedService withProperties(LinkedServiceProperties properties) {
    this.properties = properties;
    return this;
  }

  @JsonProperty("etag")
  public String getEtag() {
    return etag;
  }

  @JsonProperty("etag")
  public void setEtag(String etag) {
    this.etag = etag;
  }

  public LinkedService withEtag(String etag) {
    this.etag = etag;
    return this;
  }
}
