package com.azure.datafactory.dataset.adls;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AzureDataLakeStoreLocation {

  @JsonProperty("type")
  private String type;

  @JsonProperty("folderPath")
  private String folderPath;

  @JsonProperty("fileName")
  private String fileName;

  @JsonProperty("type")
  public String getType() {
    return type;
  }

  @JsonProperty("type")
  public void setType(String type) {
    this.type = type;
  }

  @JsonProperty("folderPath")
  public String getFolderPath() {
    return folderPath;
  }

  @JsonProperty("folderPath")
  public void setFolderPath(String folderPath) {
    this.folderPath = folderPath;
  }

  @JsonProperty("fileName")
  public String getFileName() {
    return fileName;
  }

  @JsonProperty("fileName")
  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public AzureDataLakeStoreLocation() {
  }

  private AzureDataLakeStoreLocation(String type, String folderPath, String fileName) {
    this.type = type;
    this.folderPath = folderPath;
    this.fileName = fileName;
  }

  public static class Builder {
    private String type;
    private String folderPath;
    private String fileName;

    public Builder withType(String type) {
      this.type = type;
      return this;
    }

    public Builder withFolderPath(String folderPath) {
      this.folderPath = folderPath;
      return this;
    }

    public Builder withFileName(String fileName) {
      this.fileName = fileName;
      return this;
    }

    public AzureDataLakeStoreLocation createAzureDataLakeStoreLocation() {
      return new AzureDataLakeStoreLocation(type, folderPath, fileName);
    }
  }


}
