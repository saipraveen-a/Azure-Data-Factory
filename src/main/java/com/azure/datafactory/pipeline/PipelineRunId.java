package com.azure.datafactory.pipeline;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PipelineRunId {

  @JsonProperty("runId")
  private String runId;

  @JsonProperty("runId")
  public String getRunId() {
    return runId;
  }

  @JsonProperty("runId")
  public void setRunId(String runId) {
    this.runId = runId;
  }
}