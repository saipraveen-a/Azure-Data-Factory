package com.azure.datafactory.linkedservice;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class TypeProperties {

  @JsonProperty("encryptedCredential")
  private String encryptedCredential;

  @JsonProperty("encryptedCredential")
  public String getEncryptedCredential() {
    return encryptedCredential;
  }

  @JsonProperty("encryptedCredential")
  public void setEncryptedCredential(String encryptedCredential) {
    this.encryptedCredential = encryptedCredential;
  }

  public TypeProperties withEncryptedCredential(String encryptedCredential) {
    this.encryptedCredential = encryptedCredential;
    return this;
  }
}
