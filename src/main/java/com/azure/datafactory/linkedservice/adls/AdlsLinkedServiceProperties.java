package com.azure.datafactory.linkedservice.adls;

import com.azure.datafactory.linkedservice.LinkedServiceProperties;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AdlsLinkedServiceProperties extends LinkedServiceProperties {

  @JsonProperty("typeProperties")
  private AdlsTypeProperties typeProperties;

  @JsonProperty("typeProperties")
  public AdlsTypeProperties getTypeProperties() {
    return typeProperties;
  }

  @JsonProperty("typeProperties")
  public void setTypeProperties(AdlsTypeProperties typeProperties) {
    this.typeProperties = typeProperties;
  }

  public LinkedServiceProperties withTypeProperties(AdlsTypeProperties typeProperties) {
    this.typeProperties = typeProperties;
    return this;
  }
}
