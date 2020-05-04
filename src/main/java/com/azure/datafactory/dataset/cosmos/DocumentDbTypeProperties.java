package com.azure.datafactory.dataset.cosmos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DocumentDbTypeProperties {

  @JsonProperty("collectionName")
  private String collectionName;

  public DocumentDbTypeProperties() {}

  private DocumentDbTypeProperties(String collectionName) {
    this.collectionName = collectionName;
  }

  @JsonProperty("collectionName")
  public String getCollectionName() {
    return collectionName;
  }

  @JsonProperty("collectionName")
  public void setCollectionName(String collectionName) {
    this.collectionName = collectionName;
  }

  public static class Builder {
    private String collectionName;

    public Builder withCollectionName(String collectionName) {
      this.collectionName = collectionName;
      return this;
    }

    public DocumentDbTypeProperties createDocumentDbTypeProperties() {
      return new DocumentDbTypeProperties(collectionName);
    }
  }
}
