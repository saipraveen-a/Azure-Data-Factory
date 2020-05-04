package com.azure.datafactory.linkedservice.blobstore;

import com.azure.datafactory.linkedservice.LinkedServiceRequestProperties;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BlobStoreLinkedServiceRequestProperties extends LinkedServiceRequestProperties {

  @JsonProperty("typeProperties")
  private BlobStoreTypeProperties typeProperties;

  private BlobStoreLinkedServiceRequestProperties(BlobStoreTypeProperties typeProperties) {
    this.typeProperties = typeProperties;
  }

  @JsonProperty("typeProperties")
  public BlobStoreTypeProperties getTypeProperties() {
    return typeProperties;
  }

  @JsonProperty("typeProperties")
  public void setTypeProperties(BlobStoreTypeProperties typeProperties) {
    this.typeProperties = typeProperties;
  }

  public static class Builder {
    private BlobStoreTypeProperties typeProperties;


    public Builder withTypeProperties(BlobStoreTypeProperties typeProperties) {
      this.typeProperties = typeProperties;
      return this;
    }

    public BlobStoreLinkedServiceRequestProperties createBlobStoreLinkedServiceRequestProperties() {
      return new BlobStoreLinkedServiceRequestProperties(typeProperties);
    }
  }
}
