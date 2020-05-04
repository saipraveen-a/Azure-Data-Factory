package com.azure.datafactory.linkedservice.bigquery.request;

import com.azure.datafactory.linkedservice.SecretValue;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BigQueryRequestTypeProperties {

  @JsonProperty("project")
  private String project;
  @JsonProperty("authenticationType")
  private String authenticationType;
  @JsonProperty("refreshToken")
  private SecretValue refreshToken;
  @JsonProperty("clientId")
  private SecretValue clientId;
  @JsonProperty("clientSecret")
  private SecretValue clientSecret;

  private BigQueryRequestTypeProperties(
      String project, String authenticationType, SecretValue refreshToken,
      SecretValue clientId, SecretValue clientSecret) {
    this.project = project;
    this.authenticationType = authenticationType;
    this.refreshToken = refreshToken;
    this.clientId = clientId;
    this.clientSecret = clientSecret;
  }

  @JsonProperty("project")
  public String getProject() {
    return project;
  }

  @JsonProperty("project")
  public void setProject(String project) {
    this.project = project;
  }

  @JsonProperty("authenticationType")
  public String getAuthenticationType() {
    return authenticationType;
  }

  @JsonProperty("authenticationType")
  public void setAuthenticationType(String authenticationType) {
    this.authenticationType = authenticationType;
  }

  @JsonProperty("refreshToken")
  public SecretValue getRefreshToken() {
    return refreshToken;
  }

  @JsonProperty("refreshToken")
  public void setRefreshToken(SecretValue refreshToken) {
    this.refreshToken = refreshToken;
  }

  @JsonProperty("clientId")
  public SecretValue getClientId() {
    return clientId;
  }

  @JsonProperty("clientId")
  public void setClientId(SecretValue clientId) {
    this.clientId = clientId;
  }

  @JsonProperty("clientSecret")
  public SecretValue getClientSecret() {
    return clientSecret;
  }

  @JsonProperty("clientSecret")
  public void setClientSecret(SecretValue clientSecret) {
    this.clientSecret = clientSecret;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {
    private String project;
    private String authenticationType;
    private SecretValue refreshToken;
    private SecretValue clientId;
    private SecretValue clientSecret;

    public Builder withProject(String project) {
      this.project = project;
      return this;
    }

    public Builder withAuthenticationType(String authenticationType) {
      this.authenticationType = authenticationType;
      return this;
    }

    public Builder withRefreshToken(SecretValue refreshToken) {
      this.refreshToken = refreshToken;
      return this;
    }

    public Builder withClientId(SecretValue clientId) {
      this.clientId = clientId;
      return this;
    }

    public Builder withClientSecret(SecretValue clientSecret) {
      this.clientSecret = clientSecret;
      return this;
    }

    public BigQueryRequestTypeProperties createBigQueryRequestTypeProperties() {
      return new BigQueryRequestTypeProperties(project, authenticationType, refreshToken, clientId, clientSecret);
    }
  }
}
