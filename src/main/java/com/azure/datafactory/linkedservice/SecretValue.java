package com.azure.datafactory.linkedservice;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SecretValue {

  @JsonProperty("type")
  private String type;
  @JsonProperty("value")
  private String value;

  public SecretValue() {}

  private SecretValue(String type, String value) {
    this.type = type;
    this.value = value;
  }

  @JsonProperty("type")
  public String getType() {
    return type;
  }

  @JsonProperty("type")
  public void setType(String type) {
    this.type = type;
  }


  @JsonProperty("value")
  public String getValue() {
    return value;
  }

  @JsonProperty("value")
  public void setValue(String value) {
    this.value = value;
  }

  public static class Builder {
    private String type;
    private String value;

    public Builder withType(String type) {
      this.type = type;
      return this;
    }

    public Builder withValue(String value) {
      this.value = value;
      return this;
    }

    public SecretValue createSecretValue() {
      return new SecretValue(type, value);
    }
  }
}
