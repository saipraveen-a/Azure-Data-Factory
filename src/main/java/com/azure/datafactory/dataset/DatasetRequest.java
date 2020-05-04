package com.azure.datafactory.dataset;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DatasetRequest {

  @JsonProperty("properties")
  private DatasetProperties datasetProperties;

  @JsonProperty("schema")
  private String schema;

  @JsonProperty("properties")
  public DatasetProperties getDatasetProperties() {
    return datasetProperties;
  }

  @JsonProperty("properties")
  public void setDatasetProperties(DatasetProperties datasetProperties) {
    this.datasetProperties = datasetProperties;
  }

  @JsonProperty("schema")
  public String getSchema() {
    return schema;
  }

  @JsonProperty("schema")
  public void setSchema(String schema) {
    this.schema = schema;
  }
}
