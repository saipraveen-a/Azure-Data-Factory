package com.azure.datafactory.linkedservice.keyvault;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class KeyVaultTypeProperties {
  @JsonProperty("baseUrl")
  private String baseUrl;

  @JsonProperty("baseUrl")
  public String getBaseUrl() {
    return baseUrl;
  }

  @JsonProperty("baseUrl")
  public void setBaseUrl(String baseUrl) {
    this.baseUrl = baseUrl;
  }
}
