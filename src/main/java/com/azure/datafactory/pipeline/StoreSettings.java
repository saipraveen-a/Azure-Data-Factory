package com.azure.datafactory.pipeline;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class StoreSettings {

  @JsonProperty("type")
  private String type;

  public StoreSettings() { }

  private StoreSettings(String type) {
    this.type = type;
  }

  @JsonProperty("type")
  public String getType() {
    return type;
  }

  @JsonProperty("type")
  public void setType(String type) {
    this.type = type;
  }

  public static final class Builder {
    private String type;

    public Builder withType(String type) {
      this.type = type;
      return this;
    }

    public StoreSettings createStoreSettings() {
      return new StoreSettings(type);
    }
  }
}