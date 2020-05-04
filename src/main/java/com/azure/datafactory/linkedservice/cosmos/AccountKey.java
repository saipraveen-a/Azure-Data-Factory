package com.azure.datafactory.linkedservice.cosmos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountKey {

  @JsonProperty("type")
  private String type;
  @JsonProperty("store")
  private KeyStore store;
  @JsonProperty("secretName")
  private String secretName;
  @JsonProperty("secretVersion")
  private String secretVersion;

  public AccountKey() {

  }

  public AccountKey(String type, KeyStore keyStore, String secretName, String secretVersion) {
    this.type = type;
    this.store = keyStore;
    this.secretName = secretName;
    this.secretVersion = secretVersion;
  }

  @JsonProperty("type")
  public String getType() {
    return type;
  }

  @JsonProperty("type")
  public void setType(String type) {
    this.type = type;
  }

  @JsonProperty("store")
  public KeyStore getStore() {
    return store;
  }

  @JsonProperty("store")
  public void setStore(KeyStore store) {
    this.store = store;
  }

  @JsonProperty("secretName")
  public String getSecretName() {
    return secretName;
  }

  @JsonProperty("secretName")
  public void setSecretName(String secretName) {
    this.secretName = secretName;
  }

  @JsonProperty("secretVersion")
  public String getSecretVersion() {
    return secretVersion;
  }

  @JsonProperty("secretVersion")
  public void setSecretVersion(String secretVersion) {
    this.secretVersion = secretVersion;
  }

  public static final class Builder {
    private String type;
    private KeyStore keyStore;
    private String secretName;
    private String secretVersion;

    public Builder withType(String type) {
      this.type = type;
      return this;
    }

    public Builder withKeyStore(KeyStore keyStore) {
      this.keyStore = keyStore;
      return this;
    }

    public Builder withSecretName(String secretName) {
      this.secretName = secretName;
      return this;
    }

    public Builder withSecretVersion(String secretVersion) {
      this.secretVersion = secretVersion;
      return this;
    }

    public AccountKey createAccountKey() {
      return new AccountKey(type, keyStore, secretName, secretVersion);
    }
  }
}