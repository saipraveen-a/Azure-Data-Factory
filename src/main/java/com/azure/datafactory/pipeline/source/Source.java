package com.azure.datafactory.pipeline.source;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "type",
    visible = true)
@JsonSubTypes({
    @JsonSubTypes.Type(value = DocumentDbCollectionSource.class, name = "DocumentDbCollectionSource"),
    @JsonSubTypes.Type(value = GoogleBigQuerySource.class, name = "GoogleBigQuerySource")})
public class Source {

  @JsonProperty("type")
  private String type;

  public Source() { }

  public Source(String type) {
    this.type = type;
  }

  @JsonProperty("type")
  public String getType() {
    return type;
  }

  @JsonProperty("type")
  public void setType(String type) {
    this.type = type;
  }
}
