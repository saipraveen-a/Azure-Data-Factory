package com.azure.datafactory.linkedservice;

import com.azure.datafactory.linkedservice.adls.AdlsLinkedServiceProperties;
import com.azure.datafactory.linkedservice.bigquery.response.BigQueryLinkedServiceProperties;
import com.azure.datafactory.linkedservice.blobstore.BlobStoreLinkedServiceProperties;
import com.azure.datafactory.linkedservice.cosmos.CosmosDbLinkedServiceProperties;
import com.azure.datafactory.linkedservice.keyvault.KeyVaultLinkedServiceProperties;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "type",
    visible = true)
@JsonSubTypes({
    @JsonSubTypes.Type(value = BigQueryLinkedServiceProperties.class, name = "GoogleBigQuery"),
    @JsonSubTypes.Type(value = BlobStoreLinkedServiceProperties.class, name = "AzureStorage"),
    @JsonSubTypes.Type(value = KeyVaultLinkedServiceProperties.class, name = "AzureKeyVault"),
    @JsonSubTypes.Type(value = CosmosDbLinkedServiceProperties.class, name = "CosmosDb"),
    @JsonSubTypes.Type(value = AdlsLinkedServiceProperties.class, name = "AzureDataLakeStore")})
public abstract class LinkedServiceProperties {

  @JsonProperty("type")
  private String type;

  @JsonProperty("type")
  public void setType(String type) {
    this.type = type;
  }

  public LinkedServiceProperties withType(String type) {
    this.type = type;
    return this;
  }
}
