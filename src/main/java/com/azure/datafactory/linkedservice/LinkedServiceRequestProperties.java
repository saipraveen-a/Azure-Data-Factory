package com.azure.datafactory.linkedservice;

import com.azure.datafactory.linkedservice.adls.AdlsLinkedServiceRequestProperties;
import com.azure.datafactory.linkedservice.bigquery.request.BigQueryLinkedServiceRequestProperties;
import com.azure.datafactory.linkedservice.blobstore.BlobStoreLinkedServiceRequestProperties;
import com.azure.datafactory.linkedservice.cosmos.CosmosDbLinkedServiceRequestProperties;
import com.azure.datafactory.linkedservice.keyvault.KeyVaultLinkedServiceRequestProperties;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "type",
    visible = true)
@JsonSubTypes({
    @JsonSubTypes.Type(value = BigQueryLinkedServiceRequestProperties.class, name = "GoogleBigQuery"),
    @JsonSubTypes.Type(value = BlobStoreLinkedServiceRequestProperties.class, name = "AzureStorage"),
    @JsonSubTypes.Type(value = KeyVaultLinkedServiceRequestProperties.class, name = "AzureKeyVault"),
    @JsonSubTypes.Type(value = CosmosDbLinkedServiceRequestProperties.class, name = "CosmosDb"),
    @JsonSubTypes.Type(value = AdlsLinkedServiceRequestProperties.class, name = "AzureDataLakeStore")})
public abstract class LinkedServiceRequestProperties {

}
