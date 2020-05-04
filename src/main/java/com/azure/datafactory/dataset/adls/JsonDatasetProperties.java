package com.azure.datafactory.dataset.adls;

import com.azure.datafactory.dataset.DatasetProperties;
import com.azure.datafactory.dataset.LinkedServiceName;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonDatasetProperties extends DatasetProperties {
  @JsonProperty("typeProperties")
  private JsonTypeProperties typeProperties;

  public JsonDatasetProperties() {
  }

  private JsonDatasetProperties(JsonTypeProperties typeProperties, String type, LinkedServiceName linkedServiceName) {
    super(linkedServiceName, type);
    this.typeProperties = typeProperties;
  }

  @JsonProperty("typeProperties")
  public JsonTypeProperties getTypeProperties() {
    return typeProperties;
  }

  @JsonProperty("typeProperties")
  public void setTypeProperties(JsonTypeProperties typeProperties) {
    this.typeProperties = typeProperties;
  }

  public static class Builder {
    private JsonTypeProperties typeProperties;
    private String type;
    private LinkedServiceName linkedServiceName;

    public Builder withTypeProperties(JsonTypeProperties typeProperties) {
      this.typeProperties = typeProperties;
      return this;
    }

    public Builder withType(String type) {
      this.type = type;
      return this;
    }

    public Builder withLinkedServiceName(LinkedServiceName linkedServiceName) {
      this.linkedServiceName = linkedServiceName;
      return this;
    }

    public JsonDatasetProperties createJsonDatasetProperties() {
      return new JsonDatasetProperties(typeProperties, type, linkedServiceName);
    }
  }
}
