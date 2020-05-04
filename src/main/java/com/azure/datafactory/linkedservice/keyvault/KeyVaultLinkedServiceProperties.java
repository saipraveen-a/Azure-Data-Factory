package com.azure.datafactory.linkedservice.keyvault;

import com.azure.datafactory.linkedservice.LinkedServiceProperties;

import com.fasterxml.jackson.annotation.JsonProperty;

public class KeyVaultLinkedServiceProperties extends LinkedServiceProperties {

  @JsonProperty("typeProperties")
  private KeyVaultTypeProperties typeProperties;

  @JsonProperty("typeProperties")
  public KeyVaultTypeProperties getTypeProperties() {
    return typeProperties;
  }

  @JsonProperty("typeProperties")
  public void setTypeProperties(KeyVaultTypeProperties typeProperties) {
    this.typeProperties = typeProperties;
  }

  public LinkedServiceProperties withTypeProperties(KeyVaultTypeProperties typeProperties) {
    this.typeProperties = typeProperties;
    return this;
  }
}