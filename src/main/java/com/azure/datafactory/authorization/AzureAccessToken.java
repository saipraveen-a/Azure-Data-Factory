package com.azure.datafactory.authorization;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class AzureAccessToken {

  @SerializedName("access_token")
  private String accessToken;
  @SerializedName("token_type")
  private String tokenType;
  @SerializedName("expires_in")
  private int expiresIn;
  private String resource;

  public AzureAccessToken(
      String accessToken, String resource, int expiresIn, String tokenType) {
    this.accessToken = accessToken;
    this.resource = resource;
    this.expiresIn = expiresIn;
    this.tokenType = tokenType;
  }

  public String getAccessToken() {
    return accessToken;
  }
}
