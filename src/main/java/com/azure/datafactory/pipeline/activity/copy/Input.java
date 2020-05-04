package com.azure.datafactory.pipeline.activity.copy;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Input {

  @JsonProperty("type")
  private String type;
  @JsonProperty("referenceName")
  private String referenceName;

  @JsonProperty("type")
  public String getType() {
    return type;
  }

  @JsonProperty("type")
  public void setType(String type) {
    this.type = type;
  }

  @JsonProperty("referenceName")
  public String getReferenceName() {
    return referenceName;
  }

  @JsonProperty("referenceName")
  public void setReferenceName(String referenceName) {
    this.referenceName = referenceName;
  }

}