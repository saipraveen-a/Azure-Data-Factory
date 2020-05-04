package com.azure.datafactory.linkedservice;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LinkedServiceRequest {

  @JsonProperty("properties")
  private LinkedServiceRequestProperties properties;

  public LinkedServiceRequest(LinkedServiceRequestProperties properties) {
    this.properties = properties;
  }

  @JsonProperty("properties")
  public LinkedServiceRequestProperties getProperties() {
    return properties;
  }

  public void setProperties(LinkedServiceRequestProperties properties) {
    this.properties = properties;
  }
}
