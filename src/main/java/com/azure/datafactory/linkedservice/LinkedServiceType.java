package com.azure.datafactory.linkedservice;

public enum LinkedServiceType {
  BIGQUERY("GoogleBigQuery"),
  BLOBSTORE("AzureStorage");

  private String type;

  LinkedServiceType(String type) {
    this.type = type;
  }

  public String getType() {
    return type;
  }
}
