package com.azure.datafactory.configuration.settings;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "azure.datafactory")
public class DataFactorySettings {
  private String subscriptionId;
  private String tenantId;
  private String clientId;
  private String clientSecret;
  private String name;
  private String resourceGroup;
  private String baseUrl;
  private String authorizationUrl;
  private String apiVersion;
  private String resource;
  private String pipelineNamePrefix;
  private String projectId;
  private String adlaLinkedServiceName;
  private boolean reinitializePipeline;

  public String getSubscriptionId() {
    return subscriptionId;
  }

  public void setSubscriptionId(String subscriptionId) {
    this.subscriptionId = subscriptionId;
  }

  public String getTenantId() {
    return tenantId;
  }

  public void setTenantId(String tenantId) {
    this.tenantId = tenantId;
  }

  public String getClientId() {
    return clientId;
  }

  public void setClientId(String clientId) {
    this.clientId = clientId;
  }

  public String getClientSecret() {
    return clientSecret;
  }

  public void setClientSecret(String clientSecret) {
    this.clientSecret = clientSecret;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getResourceGroup() {
    return resourceGroup;
  }

  public void setResourceGroup(String resourceGroup) {
    this.resourceGroup = resourceGroup;
  }

  public String getBaseUrl() {
    return baseUrl;
  }

  public void setBaseUrl(String baseUrl) {
    this.baseUrl = baseUrl;
  }

  public String getAuthorizationUrl() {
    return authorizationUrl;
  }

  public void setAuthorizationUrl(String authorizationUrl) {
    this.authorizationUrl = authorizationUrl;
  }

  public String getApiVersion() {
    return apiVersion;
  }

  public void setApiVersion(String apiVersion) {
    this.apiVersion = apiVersion;
  }

  public String getResource() {
    return resource;
  }

  public void setResource(String resource) {
    this.resource = resource;
  }

  public String getPipelineNamePrefix() {
    return pipelineNamePrefix;
  }

  public void setPipelineNamePrefix(String pipelineNamePrefix) {
    this.pipelineNamePrefix = pipelineNamePrefix;
  }

  public String getProjectId() {
    return projectId;
  }

  public void setProjectId(String projectId) {
    this.projectId = projectId;
  }

  public String getAdlaLinkedServiceName() {
    return adlaLinkedServiceName;
  }

  public void setAdlaLinkedServiceName(String adlaLinkedServiceName) {
    this.adlaLinkedServiceName = adlaLinkedServiceName;
  }

  public boolean isReinitializePipeline() {
    return reinitializePipeline;
  }

  public void setReinitializePipeline(boolean reinitializePipeline) {
    this.reinitializePipeline = reinitializePipeline;
  }
}
