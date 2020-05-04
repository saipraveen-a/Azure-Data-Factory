package com.azure.datafactory.linkedservice.adls;

import com.azure.datafactory.linkedservice.SecretValue;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdlsRequestTypeProperties {

  @JsonProperty("dataLakeStoreUri")
  private String dataLakeStoreUri;
  @JsonProperty("servicePrincipalId")
  private String servicePrincipalId;
  @JsonProperty("servicePrincipalKey")
  private SecretValue servicePrincipalKey;
  @JsonProperty("tenant")
  private String tenant;
  @JsonProperty("subscriptionId")
  private String subscriptionId;
  @JsonProperty("resourceGroupName")
  private String resourceGroupName;
  @JsonProperty("accountName")
  private String accountName;

  public AdlsRequestTypeProperties() {
  }

  private AdlsRequestTypeProperties(
      String dataLakeStoreUri, String servicePrincipalId, SecretValue servicePrincipalKey,
      String tenant, String subscriptionId, String resourceGroupName, String accountName) {
    this.dataLakeStoreUri = dataLakeStoreUri;
    this.servicePrincipalId = servicePrincipalId;
    this.servicePrincipalKey = servicePrincipalKey;
    this.tenant = tenant;
    this.subscriptionId = subscriptionId;
    this.resourceGroupName = resourceGroupName;
    this.accountName = accountName;
  }

  @JsonProperty("dataLakeStoreUri")
  public String getDataLakeStoreUri() {
    return dataLakeStoreUri;
  }

  @JsonProperty("dataLakeStoreUri")
  public void setDataLakeStoreUri(String dataLakeStoreUri) {
    this.dataLakeStoreUri = dataLakeStoreUri;
  }

  @JsonProperty("servicePrincipalId")
  public String getServicePrincipalId() {
    return servicePrincipalId;
  }

  @JsonProperty("servicePrincipalId")
  public void setServicePrincipalId(String servicePrincipalId) {
    this.servicePrincipalId = servicePrincipalId;
  }

  @JsonProperty("tenant")
  public String getTenant() {
    return tenant;
  }

  @JsonProperty("tenant")
  public void setTenant(String tenant) {
    this.tenant = tenant;
  }

  @JsonProperty("subscriptionId")
  public String getSubscriptionId() {
    return subscriptionId;
  }

  @JsonProperty("subscriptionId")
  public void setSubscriptionId(String subscriptionId) {
    this.subscriptionId = subscriptionId;
  }

  @JsonProperty("resourceGroupName")
  public String getResourceGroupName() {
    return resourceGroupName;
  }

  @JsonProperty("resourceGroupName")
  public void setResourceGroupName(String resourceGroupName) {
    this.resourceGroupName = resourceGroupName;
  }

  @JsonProperty("servicePrincipalKey")
  public SecretValue getServicePrincipalKey() {
    return servicePrincipalKey;
  }

  @JsonProperty("servicePrincipalKey")
  public void setServicePrincipalKey(SecretValue servicePrincipalKey) {
    this.servicePrincipalKey = servicePrincipalKey;
  }

  @JsonProperty("accountName")
  public String getAccountName() {
    return accountName;
  }

  @JsonProperty("accountName")
  public void setAccountName(String accountName) {
    this.accountName = accountName;
  }

  public static final class Builder {
    private String dataLakeStoreUri;
    private String servicePrincipalId;
    private SecretValue servicePrincipalKey;
    private String tenant;
    private String subscriptionId;
    private String resourceGroupName;
    private String accountName;

    public Builder withDataLakeStoreUri(String dataLakeStoreUri) {
      this.dataLakeStoreUri = dataLakeStoreUri;
      return this;
    }

    public Builder withServicePrincipalId(String servicePrincipalId) {
      this.servicePrincipalId = servicePrincipalId;
      return this;
    }

    public Builder withServicePrincipalKey(SecretValue servicePrincipalKey) {
      this.servicePrincipalKey = servicePrincipalKey;
      return this;
    }

    public Builder withTenant(String tenant) {
      this.tenant = tenant;
      return this;
    }

    public Builder withSubscriptionId(String subscriptionId) {
      this.subscriptionId = subscriptionId;
      return this;
    }

    public Builder withResourceGroupName(String resourceGroupName) {
      this.resourceGroupName = resourceGroupName;
      return this;
    }

    public Builder withAccountName(String accountName) {
      this.accountName = accountName;
      return this;
    }

    public AdlsRequestTypeProperties createAdlsRequestTypeProperties() {
      return new AdlsRequestTypeProperties(dataLakeStoreUri, servicePrincipalId, servicePrincipalKey, tenant,
          subscriptionId, resourceGroupName, accountName);
    }
  }
}