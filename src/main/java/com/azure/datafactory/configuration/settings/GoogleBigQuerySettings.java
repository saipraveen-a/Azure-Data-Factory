package com.azure.datafactory.configuration.settings;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "azure.datafactory.bigquery")
public class GoogleBigQuerySettings {

  private String defaultProjectId;
  private String authenticationType;
  private String clientId;
  private String clientSecret;
  private String refreshToken;

  public String getDefaultProjectId() {
    return defaultProjectId;
  }

  public String getAuthenticationType() {
    return authenticationType;
  }

  public String getClientId() {
    return clientId;
  }

  public String getClientSecret() {
    return clientSecret;
  }

  public String getRefreshToken() {
    return refreshToken;
  }

  public void setDefaultProjectId(String defaultProjectId) {
    this.defaultProjectId = defaultProjectId;
  }

  public void setAuthenticationType(String authenticationType) {
    this.authenticationType = authenticationType;
  }

  public void setClientId(String clientId) {
    this.clientId = clientId;
  }

  public void setClientSecret(String clientSecret) {
    this.clientSecret = clientSecret;
  }

  public void setRefreshToken(String refreshToken) {
    this.refreshToken = refreshToken;
  }
}
