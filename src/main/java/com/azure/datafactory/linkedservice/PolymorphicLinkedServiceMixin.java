package com.azure.datafactory.linkedservice;

import com.azure.datafactory.linkedservice.bigquery.response.BigQueryLinkedServiceProperties;
import com.azure.datafactory.linkedservice.blobstore.BlobStoreLinkedServiceProperties;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    property = "type")
@JsonSubTypes(value = {
    @JsonSubTypes.Type(value = BigQueryLinkedServiceProperties.class, name = "GoogleBigQuery"),
    @JsonSubTypes.Type(value = BlobStoreLinkedServiceProperties.class, name = "AzureStorage")})
public abstract class PolymorphicLinkedServiceMixin {
}
