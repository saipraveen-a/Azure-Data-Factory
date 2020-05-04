package com.azure.datafactory.linkedservice.keyvault;

import com.azure.datafactory.linkedservice.LinkedServiceRequestProperties;
import com.azure.datafactory.linkedservice.bigquery.request.BigQueryRequestTypeProperties;

import com.fasterxml.jackson.annotation.JsonProperty;

public class KeyVaultLinkedServiceRequestProperties extends LinkedServiceRequestProperties {

  @JsonProperty("typeProperties")
  private BigQueryRequestTypeProperties typeProperties;

  private KeyVaultLinkedServiceRequestProperties(BigQueryRequestTypeProperties typeProperties) {
    this.typeProperties = typeProperties;
  }

  @JsonProperty("typeProperties")
  public BigQueryRequestTypeProperties getTypeProperties() {
    return typeProperties;
  }

  @JsonProperty("typeProperties")
  public void setTypeProperties(BigQueryRequestTypeProperties typeProperties) {
    this.typeProperties = typeProperties;
  }

  public static class Builder {
    private BigQueryRequestTypeProperties typeProperties;

    public Builder withTypeProperties(BigQueryRequestTypeProperties typeProperties) {
      this.typeProperties = typeProperties;
      return this;
    }
  }
}
