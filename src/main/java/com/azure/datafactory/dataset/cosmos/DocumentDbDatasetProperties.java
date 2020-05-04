package com.azure.datafactory.dataset.cosmos;

import com.azure.datafactory.dataset.DatasetProperties;
import com.azure.datafactory.dataset.LinkedServiceName;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DocumentDbDatasetProperties extends DatasetProperties {
  @JsonProperty("typeProperties")
  private DocumentDbTypeProperties typeProperties;

  public DocumentDbDatasetProperties() {
  }

  private DocumentDbDatasetProperties(DocumentDbTypeProperties typeProperties, String type, LinkedServiceName linkedServiceName) {
    super(linkedServiceName, type);
    this.typeProperties = typeProperties;
  }

  @JsonProperty("typeProperties")
  public DocumentDbTypeProperties getTypeProperties() {
    return typeProperties;
  }

  @JsonProperty("typeProperties")
  public void setTypeProperties(DocumentDbTypeProperties typeProperties) {
    this.typeProperties = typeProperties;
  }

  public static class Builder {
    private DocumentDbTypeProperties typeProperties;
    private String type;
    private LinkedServiceName linkedServiceName;

    public Builder withTypeProperties(DocumentDbTypeProperties typeProperties) {
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

    public DocumentDbDatasetProperties createDocumentDbDatasetProperties() {
      return new DocumentDbDatasetProperties(typeProperties, type, linkedServiceName);
    }
  }
}
