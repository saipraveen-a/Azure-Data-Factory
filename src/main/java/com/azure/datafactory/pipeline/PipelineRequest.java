package com.azure.datafactory.pipeline;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class PipelineRequest {

  @JsonProperty("properties")
  private PipelineProperties properties;

  @JsonProperty("properties")
  public PipelineProperties getProperties() {
    return properties;
  }

  @JsonProperty("properties")
  public void setProperties(PipelineProperties properties) {
    this.properties = properties;
  }
}