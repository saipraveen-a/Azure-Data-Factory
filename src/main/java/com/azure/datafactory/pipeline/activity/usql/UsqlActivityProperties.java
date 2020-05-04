package com.azure.datafactory.pipeline.activity.usql;

import com.azure.datafactory.pipeline.activity.ActivityProperties;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsqlActivityProperties extends ActivityProperties {
  @JsonProperty("scriptPath")
  private String scriptPath;
  @JsonProperty("scriptLinkedService")
  private ScriptLinkedService scriptLinkedService;

  public UsqlActivityProperties() {
  }

  private UsqlActivityProperties(String scriptPath, ScriptLinkedService scriptLinkedService) {
    this.scriptPath = scriptPath;
    this.scriptLinkedService = scriptLinkedService;
  }

  @JsonProperty("scriptPath")
  public String getScriptPath() {
    return scriptPath;
  }

  @JsonProperty("scriptPath")
  public void setScriptPath(String scriptPath) {
    this.scriptPath = scriptPath;
  }

  @JsonProperty("scriptLinkedService")
  public ScriptLinkedService getScriptLinkedService() {
    return scriptLinkedService;
  }

  @JsonProperty("scriptLinkedService")
  public void setScriptLinkedService(ScriptLinkedService scriptLinkedService) {
    this.scriptLinkedService = scriptLinkedService;
  }

  public static final class Builder {
    private String scriptPath;
    private ScriptLinkedService scriptLinkedService;

    public Builder withScriptPath(String scriptPath) {
      this.scriptPath = scriptPath;
      return this;
    }

    public Builder withScriptLinkedService(ScriptLinkedService scriptLinkedService) {
      this.scriptLinkedService = scriptLinkedService;
      return this;
    }

    public UsqlActivityProperties createUsqlActivityProperties() {
      return new UsqlActivityProperties(scriptPath, scriptLinkedService);
    }
  }
}