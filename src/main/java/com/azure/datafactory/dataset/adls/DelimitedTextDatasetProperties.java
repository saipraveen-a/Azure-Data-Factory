package com.azure.datafactory.dataset.adls;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.azure.datafactory.dataset.DatasetProperties;
import com.azure.datafactory.dataset.LinkedServiceName;

public class DelimitedTextDatasetProperties extends DatasetProperties {
  @JsonProperty("typeProperties")
  private DelimitedTextTypeProperties typeProperties;

  public DelimitedTextDatasetProperties() {
  }

  private DelimitedTextDatasetProperties(DelimitedTextTypeProperties typeProperties, String type, LinkedServiceName linkedServiceName) {
    super(linkedServiceName, type);
    this.typeProperties = typeProperties;
  }

  @JsonProperty("typeProperties")
  public DelimitedTextTypeProperties getTypeProperties() {
    return typeProperties;
  }

  @JsonProperty("typeProperties")
  public void setTypeProperties(DelimitedTextTypeProperties typeProperties) {
    this.typeProperties = typeProperties;
  }

  public static class Builder {
    private DelimitedTextTypeProperties typeProperties;
    private String type;
    private LinkedServiceName linkedServiceName;

    public Builder withTypeProperties(DelimitedTextTypeProperties typeProperties) {
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

    public DelimitedTextDatasetProperties createDelimitedTextDatasetProperties() {
      return new DelimitedTextDatasetProperties(typeProperties, type, linkedServiceName);
    }
  }
}
