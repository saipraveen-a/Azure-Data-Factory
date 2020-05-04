package com.azure.datafactory.dataset;

import com.azure.datafactory.dataset.adls.DelimitedTextDatasetProperties;
import com.azure.datafactory.dataset.adls.JsonDatasetProperties;
import com.azure.datafactory.dataset.bigquery.BigqueryDatasetProperties;
import com.azure.datafactory.dataset.cosmos.DocumentDbDatasetProperties;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "type",
    visible = true)
@JsonSubTypes({
    @JsonSubTypes.Type(value = DocumentDbDatasetProperties.class, name = "DocumentDbCollection"),
    @JsonSubTypes.Type(value = BigqueryDatasetProperties.class, name = "GoogleBigQueryObject"),
    @JsonSubTypes.Type(value = DelimitedTextDatasetProperties.class, name = "DelimitedText"),
    @JsonSubTypes.Type(value = JsonDatasetProperties.class, name = "Json")})
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class DatasetProperties {

  @JsonProperty("linkedServiceName")
  private LinkedServiceName linkedServiceName;
  @JsonProperty("type")
  private String type;

  public DatasetProperties() {}

  public DatasetProperties(LinkedServiceName linkedServiceName, String type) {
    this.linkedServiceName = linkedServiceName;
    this.type = type;
  }

  @JsonProperty("linkedServiceName")
  public LinkedServiceName getLinkedServiceName() {
    return linkedServiceName;
  }

  @JsonProperty("linkedServiceName")
  public void setLinkedServiceName(LinkedServiceName linkedServiceName) {
    this.linkedServiceName = linkedServiceName;
  }

  @JsonProperty("type")
  public String getType() {
    return type;
  }

  @JsonProperty("type")
  public void setType(String type) {
    this.type = type;
  }
}
