package com.azure.datafactory.pipeline.sink;

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
    @JsonSubTypes.Type(value = JsonSink.class, name = "JsonSink"),
    @JsonSubTypes.Type(value = DelimitedTextSink.class, name = "DelimitedTextSink")})
public class Sink {

  @JsonProperty("type")
  private String type;

  public Sink() { }

  public Sink(String type) {
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
