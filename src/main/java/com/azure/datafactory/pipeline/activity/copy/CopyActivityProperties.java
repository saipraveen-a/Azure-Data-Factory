package com.azure.datafactory.pipeline.activity.copy;

import com.azure.datafactory.pipeline.activity.ActivityProperties;
import com.azure.datafactory.pipeline.sink.Sink;
import com.azure.datafactory.pipeline.source.Source;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CopyActivityProperties extends ActivityProperties {

  @JsonProperty("source")
  private Source source;
  @JsonProperty("sink")
  private Sink sink;

  public CopyActivityProperties() {
  }

  private CopyActivityProperties(Source source, Sink sink) {
    this.source = source;
    this.sink = sink;
  }

  @JsonProperty("source")
  public Source getSource() {
    return source;
  }

  @JsonProperty("source")
  public void setSource(Source source) {
    this.source = source;
  }

  @JsonProperty("sink")
  public Sink getSink() {
    return sink;
  }

  @JsonProperty("sink")
  public void setSink(Sink sink) {
    this.sink = sink;
  }

  public static final class Builder {
    private Source source;
    private Sink sink;

    public Builder withSource(Source source) {
      this.source = source;
      return this;
    }

    public Builder withSink(Sink sink) {
      this.sink = sink;
      return this;
    }

    public CopyActivityProperties createCopyActivityProperties() {
      return new CopyActivityProperties(source, sink);
    }
  }
}