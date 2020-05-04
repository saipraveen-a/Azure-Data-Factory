package com.azure.datafactory.pipeline;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class Pipeline {

  @JsonProperty("id")
  private String id;
  @JsonProperty("name")
  private String name;
  @JsonProperty("type")
  private String type;
  @JsonProperty("properties")
  private PipelineProperties properties;

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

  @JsonProperty("name")
  public String getName() {
    return name;
  }

  @JsonProperty("name")
  public void setName(String name) {
    this.name = name;
  }

  @JsonProperty("type")
  public String getType() {
    return type;
  }

  @JsonProperty("type")
  public void setType(String type) {
    this.type = type;
  }

  @JsonProperty("properties")
  public PipelineProperties getProperties() {
    return properties;
  }

  @JsonProperty("properties")
  public void setProperties(PipelineProperties properties) {
    this.properties = properties;
  }

  @JsonProperty("etag")
  public void setEtag(String etag) {
    this.etag = etag;
  }
}