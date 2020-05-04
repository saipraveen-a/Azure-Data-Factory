package com.azure.datafactory.dataset.bigquery;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.azure.datafactory.dataset.DatasetProperties;
import com.azure.datafactory.dataset.LinkedServiceName;

public class BigqueryDatasetProperties extends DatasetProperties {
  @JsonProperty("typeProperties")
  private BigqueryTypeProperties typeProperties;

  public BigqueryDatasetProperties() {
  }

  private BigqueryDatasetProperties(BigqueryTypeProperties typeProperties, String type, LinkedServiceName linkedServiceName) {
    super(linkedServiceName, type);
    this.typeProperties = typeProperties;
  }

  @JsonProperty("typeProperties")
  public BigqueryTypeProperties getTypeProperties() {
    return typeProperties;
  }

  @JsonProperty("typeProperties")
  public void setTypeProperties(BigqueryTypeProperties typeProperties) {
    this.typeProperties = typeProperties;
  }

  public static class Builder {
    private BigqueryTypeProperties typeProperties;
    private String type;
    private LinkedServiceName linkedServiceName;

    public Builder withTypeProperties(BigqueryTypeProperties typeProperties) {
      this.typeProperties = typeProperties;
      return this;
    }

    public Builder withType(String type) {
      this.type = type;
      return this;
    }

    public Builder withLinkedServiceName(LinkedServiceName linkedServiceName) {
      this.linkedServiceName = linkedServiceName;
      return this;
    }

    public BigqueryDatasetProperties createBigqueryDatasetProperties() {
      return new BigqueryDatasetProperties(typeProperties, type, linkedServiceName);
    }
  }
}
