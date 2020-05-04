package com.azure.datafactory.pipeline.activity.usql;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ScriptLinkedService {

  @JsonProperty("referenceName")
  private String referenceName;
  @JsonProperty("type")
  private String type;

  public ScriptLinkedService() {}

  private ScriptLinkedService(String referenceName, String type) {
    this.referenceName = referenceName;
    this.type = type;
  }

  @JsonProperty("referenceName")
  public String getReferenceName() {
    return referenceName;
  }

  @JsonProperty("referenceName")
  public void setReferenceName(String referenceName) {
    this.referenceName = referenceName;
  }

  @JsonProperty("type")
  public String getType() {
    return type;
  }

  @JsonProperty("type")
  public void setType(String type) {
    this.type = type;
  }

  public static final class Builder {
    private String referenceName;
    private String type;

    public Builder withReferenceName(String referenceName) {
      this.referenceName = referenceName;
      return this;
    }

    public Builder withType(String type) {
      this.type = type;
      return this;
    }

    public ScriptLinkedService createScriptLinkedService() {
      return new ScriptLinkedService(referenceName, type);
    }
  }
}