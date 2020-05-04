package com.azure.datafactory.linkedservice.cosmos;

import com.azure.datafactory.linkedservice.LinkedServiceRequestProperties;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CosmosDbLinkedServiceRequestProperties extends LinkedServiceRequestProperties {

  @JsonProperty("typeProperties")
  private CosmosDbTypeProperties typeProperties;

  public CosmosDbLinkedServiceRequestProperties() {
  }

  public CosmosDbLinkedServiceRequestProperties(CosmosDbTypeProperties typeProperties) {
    super();
    this.typeProperties = typeProperties;
  }

  @JsonProperty("typeProperties")
  public CosmosDbTypeProperties getTypeProperties() {
    return typeProperties;
  }

  @JsonProperty("typeProperties")
  public void setTypeProperties(CosmosDbTypeProperties typeProperties) {
    this.typeProperties = typeProperties;
  }

  public LinkedServiceRequestProperties withTypeProperties(CosmosDbTypeProperties typeProperties) {
    this.typeProperties = typeProperties;
    return this;
  }

  public static class Builder {
    private CosmosDbTypeProperties typeProperties;

    public Builder withTypeProperties(CosmosDbTypeProperties typeProperties) {
      this.typeProperties = typeProperties;
      return this;
    }

    public CosmosDbLinkedServiceRequestProperties createCosmosDbLinkedServiceRequestProperties() {
      return new CosmosDbLinkedServiceRequestProperties(typeProperties);
    }
  }
}