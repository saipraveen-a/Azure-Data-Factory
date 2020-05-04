package com.azure.datafactory.linkedservice.blobstore;

import com.azure.datafactory.linkedservice.LinkedServiceProperties;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BlobStoreLinkedServiceProperties extends LinkedServiceProperties {

  @JsonProperty("typeProperties")
  private BlobStoreTypeProperties typeProperties;

  @JsonProperty("typeProperties")
  public BlobStoreTypeProperties getTypeProperties() {
    return typeProperties;
  }

  @JsonProperty("typeProperties")
  public void setTypeProperties(BlobStoreTypeProperties typeProperties) {
    this.typeProperties = typeProperties;
  }

  public LinkedServiceProperties withTypeProperties(BlobStoreTypeProperties typeProperties) {
    this.typeProperties = typeProperties;
    return this;
  }
}
