package com.azure.datafactory.pipeline.sink;

public enum SinkType {
  JSON("JsonSink"),
  DELIMITED_TEXT_SINK("DelimitedTextSink");;

  private String type;

  SinkType(String type) {
    this.type = type;
  }

  public String getType() {
    return type;
  }
}
