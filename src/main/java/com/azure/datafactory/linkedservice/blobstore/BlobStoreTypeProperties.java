package com.azure.datafactory.linkedservice.blobstore;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BlobStoreTypeProperties {

  @JsonProperty("connectionString")
  private ConnectionString connectionString;

  @JsonProperty("connectionString")
  public ConnectionString getConnectionString() {
    return connectionString;
  }

  @JsonProperty("connectionString")
  public void setConnectionString(ConnectionString connectionString) {
    this.connectionString = connectionString;
  }

  public BlobStoreTypeProperties withConnectionString(ConnectionString connectionString) {
    this.connectionString = connectionString;
    return this;
  }
}
