package com.azure.datafactory.pipeline;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FormatSettings {

  @JsonProperty("type")
  private String type;

  @JsonProperty("filePattern")
  private String filePattern;

  public FormatSettings() { }

  private FormatSettings(String type, String filePattern) {
    this.type = type;
    this.filePattern = filePattern;
  }

  @JsonProperty("type")
  public String getType() {
    return type;
  }

  @JsonProperty("type")
  public void setType(String type) {
    this.type = type;
  }

  @JsonProperty("filePattern")
  public String getFilePattern() {
    return filePattern;
  }

  @JsonProperty("filePattern")
  public void setFilePattern(String filePattern) {
    this.filePattern = filePattern;
  }

  public static final class Builder {
    private String type;
    private String filePattern;

    public Builder withType(String type) {
      this.type = type;
      return this;
    }

    public Builder withFilePattern(String filePattern) {
      this.filePattern = filePattern;
      return this;
    }

    public FormatSettings createFormatSettings() {
      return new FormatSettings(type, filePattern);
    }
  }
}
