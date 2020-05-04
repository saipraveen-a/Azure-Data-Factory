package com.azure.datafactory.linkedservice.bigquery.request;

import com.azure.datafactory.linkedservice.LinkedServiceRequestProperties;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BigQueryLinkedServiceRequestProperties extends LinkedServiceRequestProperties {

  @JsonProperty("typeProperties")
  private BigQueryRequestTypeProperties typeProperties;

  private BigQueryLinkedServiceRequestProperties(BigQueryRequestTypeProperties typeProperties) {
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

    public BigQueryLinkedServiceRequestProperties createBigQueryLinkedServiceRequestProperties() {
      return new BigQueryLinkedServiceRequestProperties(typeProperties);
    }
  }
}
