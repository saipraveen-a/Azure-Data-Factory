package com.azure.datafactory.linkedservice.cosmos;

import com.azure.datafactory.linkedservice.LinkedServiceProperties;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CosmosDbLinkedServiceProperties extends LinkedServiceProperties {

  @JsonProperty("typeProperties")
  private CosmosDbTypeProperties typeProperties;

  @JsonProperty("typeProperties")
  public CosmosDbTypeProperties getTypeProperties() {
    return typeProperties;
  }

  @JsonProperty("typeProperties")
  public void setTypeProperties(CosmosDbTypeProperties typeProperties) {
    this.typeProperties = typeProperties;
  }

  public LinkedServiceProperties withTypeProperties(CosmosDbTypeProperties typeProperties) {
    this.typeProperties = typeProperties;
    return this;
  }
}