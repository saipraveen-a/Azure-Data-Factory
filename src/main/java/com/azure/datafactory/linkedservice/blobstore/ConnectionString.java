package com.azure.datafactory.linkedservice.blobstore;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConnectionString {

  @JsonProperty("type")
  private String type;
  @JsonProperty("value")
  private String value;

  @JsonProperty("type")
  public String getType() {
    return type;
  }

  @JsonProperty("type")
  public void setType(String type) {
    this.type = type;
  }

  public ConnectionString withType(String type) {
    this.type = type;
    return this;
  }

  @JsonProperty("value")
  public String getValue() {
    return value;
  }

  @JsonProperty("value")
  public void setValue(String value) {
    this.value = value;
  }

  public ConnectionString withValue(String value) {
    this.value = value;
    return this;
  }
}
