package com.azure.datafactory.linkedservice.cosmos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CosmosDbTypeProperties {

  @JsonProperty("connectionString")
  private String connectionString;
  @JsonProperty("accountKey")
  private AccountKey accountKey;

  public CosmosDbTypeProperties() {

  }
  private CosmosDbTypeProperties(String connectionString, AccountKey accountKey) {
    this.connectionString = connectionString;
    this.accountKey = accountKey;
  }

  @JsonProperty("connectionString")
  public String getConnectionString() {
    return connectionString;
  }

  @JsonProperty("connectionString")
  public void setConnectionString(String connectionString) {
    this.connectionString = connectionString;
  }

  @JsonProperty("accountKey")
  public AccountKey getAccountKey() {
    return accountKey;
  }

  @JsonProperty("accountKey")
  public void setAccountKey(AccountKey accountKey) {
    this.accountKey = accountKey;
  }

  public static final class Builder {
    private String connectionString;
    private AccountKey accountKey;

    public Builder withConnectionString(String connectionString) {
      this.connectionString = connectionString;
      return this;
    }

    public Builder withAccountKey(AccountKey accountKey) {
      this.accountKey = accountKey;
      return this;
    }

    public CosmosDbTypeProperties createCosmosDbTypeProperties() {
      return new CosmosDbTypeProperties(connectionString, accountKey);
    }
  }
}