package com.azure.datafactory.linkedservice.bigquery.response;

import com.azure.datafactory.linkedservice.LinkedServiceProperties;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BigQueryLinkedServiceProperties extends LinkedServiceProperties {

  @JsonProperty("typeProperties")
  private BigQueryTypeProperties typeProperties;

  @JsonProperty("typeProperties")
  public BigQueryTypeProperties getTypeProperties() {
    return typeProperties;
  }

  @JsonProperty("typeProperties")
  public void setTypeProperties(BigQueryTypeProperties typeProperties) {
    this.typeProperties = typeProperties;
  }

  public LinkedServiceProperties withTypeProperties(BigQueryTypeProperties typeProperties) {
    this.typeProperties = typeProperties;
    return this;
  }
}
