package com.azure.datafactory.dataset;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LinkedServiceName {

  @JsonProperty("type")
  private String type;
  @JsonProperty("referenceName")
  private String referenceName;

  public LinkedServiceName() {}

  private LinkedServiceName(String type, String referenceName) {
    this.type = type;
    this.referenceName = referenceName;
  }

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

  public static class Builder {
    private String type;
    private String referenceName;

    public Builder withType(String type) {
      this.type = type;
      return this;
    }

    public Builder withReferenceName(String referenceName) {
      this.referenceName = referenceName;
      return this;
    }

    public LinkedServiceName createLinkedServiceName() {
      return new LinkedServiceName(type, referenceName);
    }
  }
}
