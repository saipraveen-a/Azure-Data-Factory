package com.azure.datafactory.linkedservice.adls;

import com.azure.datafactory.linkedservice.LinkedServiceRequestProperties;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AdlsLinkedServiceRequestProperties extends LinkedServiceRequestProperties {

  @JsonProperty("typeProperties")
  private AdlsRequestTypeProperties typeProperties;

  public AdlsLinkedServiceRequestProperties() { }

  public AdlsLinkedServiceRequestProperties(AdlsRequestTypeProperties typeProperties) {
    super();
    this.typeProperties = typeProperties;
  }

  @JsonProperty("typeProperties")
  public AdlsRequestTypeProperties getTypeProperties() {
    return typeProperties;
  }

  @JsonProperty("typeProperties")
  public void setTypeProperties(AdlsRequestTypeProperties typeProperties) {
    this.typeProperties = typeProperties;
  }

  public LinkedServiceRequestProperties withTypeProperties(AdlsRequestTypeProperties typeProperties) {
    this.typeProperties = typeProperties;
    return this;
  }

  public static class Builder {
    private AdlsRequestTypeProperties typeProperties;

    public Builder withTypeProperties(AdlsRequestTypeProperties typeProperties) {
      this.typeProperties = typeProperties;
      return this;
    }

    public AdlsLinkedServiceRequestProperties createAdlsLinkedServiceRequestProperties() {
      return new AdlsLinkedServiceRequestProperties(typeProperties);
    }
  }
}
