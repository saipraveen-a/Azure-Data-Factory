package com.azure.datafactory.dataset.adls;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonTypeProperties {

  @JsonProperty("folderPath")
  private String folderPath;

  @JsonProperty("fileName")
  private String fileName;

  @JsonProperty("location")
  private AzureDataLakeStoreLocation location;

  public JsonTypeProperties() {}

  private JsonTypeProperties(String folderPath, String fileName, AzureDataLakeStoreLocation location) {
    this.folderPath = folderPath;
    this.fileName = fileName;
    this.location = location;
  }

  @JsonProperty("folderPath")
  public String getfolderPath() {
    return folderPath;
  }

  @JsonProperty("folderPath")
  public void setFolderPath(String folderPath) {
    this.folderPath = folderPath;
  }

  @JsonProperty("fileName")
  public String getQuoteChar() {
    return fileName;
  }

  @JsonProperty("fileName")
  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  @JsonProperty("location")
  public AzureDataLakeStoreLocation getLocation() {
    return location;
  }

  @JsonProperty("location")
  public void setLocation(AzureDataLakeStoreLocation location) {
    this.location = location;
  }

  public static class Builder {
    private String folderPath;
    private String fileName;
    private AzureDataLakeStoreLocation location;

    public Builder withFolderPath(String folderPath) {
      this.folderPath = folderPath;
      return this;
    }

    public Builder withFileName(String fileName) {
      this.fileName = fileName;
      return this;
    }

    public Builder withAzureDataLakeStoreLocation(AzureDataLakeStoreLocation location) {
      this.location = location;
      return this;
    }

    public JsonTypeProperties createJsonTypeProperties() {
      return new JsonTypeProperties(folderPath, fileName, location);
    }
  }
}
