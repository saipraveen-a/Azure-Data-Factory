package com.azure.datafactory.linkedservice.adls;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdlsTypeProperties {

  @JsonProperty("dataLakeStoreUri")
  private String dataLakeStoreUri;
  @JsonProperty("servicePrincipalId")
  private String servicePrincipalId;
  @JsonProperty("tenant")
  private String tenant;
  @JsonProperty("subscriptionId")
  private String subscriptionId;
  @JsonProperty("resourceGroupName")
  private String resourceGroupName;
  @JsonProperty("accountName")
  private String accountName;
  @JsonProperty("encryptedCredential")
  private String encryptedCredential;

  public AdlsTypeProperties() {
  }

  private AdlsTypeProperties(
      String dataLakeStoreUri, String servicePrincipalId, String tenant, String subscriptionId,
      String resourceGroupName, String accountName) {
    this.dataLakeStoreUri = dataLakeStoreUri;
    this.servicePrincipalId = servicePrincipalId;
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

  @JsonProperty("accountName")
  public String getAccountName() {
    return accountName;
  }

  @JsonProperty("accountName")
  public void setAccountName(String accountName) {
    this.accountName = accountName;
  }

  @JsonProperty("encryptedCredential")
  public String getEncryptedCredential() {
    return encryptedCredential;
  }

  @JsonProperty("encryptedCredential")
  public void setEncryptedCredential(String encryptedCredential) {
    this.encryptedCredential = encryptedCredential;
  }

  public static final class Builder {
    private String dataLakeStoreUri;
    private String servicePrincipalId;
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

    public AdlsTypeProperties createAdlsTypeProperties() {
      return new AdlsTypeProperties(dataLakeStoreUri, servicePrincipalId, tenant, subscriptionId, resourceGroupName,
          accountName);
    }
  }
}