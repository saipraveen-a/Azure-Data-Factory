package com.azure.datafactory.linkedservice.bigquery.response;

import com.azure.datafactory.linkedservice.TypeProperties;
import com.azure.datafactory.linkedservice.SecretValue;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BigQueryTypeProperties extends TypeProperties {

  @JsonProperty("project")
  private String project;
  @JsonProperty("authenticationType")
  private String authenticationType;
  @JsonProperty("clientId")
  private SecretValue clientId;

  @JsonProperty("project")
  public String getProject() {
    return project;
  }

  @JsonProperty("project")
  public void setProject(String project) {
    this.project = project;
  }

  public BigQueryTypeProperties withProject(String project) {
    this.project = project;
    return this;
  }

  @JsonProperty("authenticationType")
  public String getAuthenticationType() {
    return authenticationType;
  }

  @JsonProperty("authenticationType")
  public void setAuthenticationType(String authenticationType) {
    this.authenticationType = authenticationType;
  }

  public BigQueryTypeProperties withAuthenticationType(String authenticationType) {
    this.authenticationType = authenticationType;
    return this;
  }

  @JsonProperty("clientId")
  public SecretValue getClientId() {
    return clientId;
  }

  @JsonProperty("clientId")
  public void setClientId(SecretValue clientId) {
    this.clientId = clientId;
  }

  public BigQueryTypeProperties withClientId(SecretValue clientId) {
    this.clientId = clientId;
    return this;
  }

}
