package com.azure.datafactory.pipeline;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PipelineRun {

  @JsonProperty("id")
  private String id;
  @JsonProperty("runId")
  private String runId;
  @JsonProperty("debugRunId")
  private Object debugRunId;
  @JsonProperty("runGroupId")
  private String runGroupId;
  @JsonProperty("pipelineName")
  private String pipelineName;
  @JsonProperty("parameters")
  private PipelineParameters parameters;
  @JsonProperty("invokedBy")
  private InvokedBy invokedBy;
  @JsonProperty("runStart")
  private String runStart;
  @JsonProperty("runEnd")
  private String runEnd;
  @JsonProperty("durationInMs")
  private Integer durationInMs;
  @JsonProperty("status")
  private String status;
  @JsonProperty("message")
  private String message;
  @JsonProperty("lastUpdated")
  private String lastUpdated;
  @JsonProperty("annotations")
  private List<Object> annotations = null;
  @JsonProperty("runDimension")
  private RunDimension runDimension;
  @JsonProperty("isLatest")
  private Boolean isLatest;

  @JsonProperty("id")
  public String getId() {
    return id;
  }

  @JsonProperty("id")
  public void setId(String id) {
    this.id = id;
  }

  @JsonProperty("runId")
  public String getRunId() {
    return runId;
  }

  @JsonProperty("runId")
  public void setRunId(String runId) {
    this.runId = runId;
  }

  @JsonProperty("debugRunId")
  public Object getDebugRunId() {
    return debugRunId;
  }

  @JsonProperty("debugRunId")
  public void setDebugRunId(Object debugRunId) {
    this.debugRunId = debugRunId;
  }

  @JsonProperty("runGroupId")
  public String getRunGroupId() {
    return runGroupId;
  }

  @JsonProperty("runGroupId")
  public void setRunGroupId(String runGroupId) {
    this.runGroupId = runGroupId;
  }

  @JsonProperty("pipelineName")
  public String getPipelineName() {
    return pipelineName;
  }

  @JsonProperty("pipelineName")
  public void setPipelineName(String pipelineName) {
    this.pipelineName = pipelineName;
  }

  @JsonProperty("parameters")
  public PipelineParameters getParameters() {
    return parameters;
  }

  @JsonProperty("parameters")
  public void setParameters(PipelineParameters parameters) {
    this.parameters = parameters;
  }

  @JsonProperty("invokedBy")
  public InvokedBy getInvokedBy() {
    return invokedBy;
  }

  @JsonProperty("invokedBy")
  public void setInvokedBy(InvokedBy invokedBy) {
    this.invokedBy = invokedBy;
  }

  @JsonProperty("runStart")
  public String getRunStart() {
    return runStart;
  }

  @JsonProperty("runStart")
  public void setRunStart(String runStart) {
    this.runStart = runStart;
  }

  @JsonProperty("runEnd")
  public String getRunEnd() {
    return runEnd;
  }

  @JsonProperty("runEnd")
  public void setRunEnd(String runEnd) {
    this.runEnd = runEnd;
  }

  @JsonProperty("durationInMs")
  public Integer getDurationInMs() {
    return durationInMs;
  }

  @JsonProperty("durationInMs")
  public void setDurationInMs(Integer durationInMs) {
    this.durationInMs = durationInMs;
  }

  @JsonProperty("status")
  public String getStatus() {
    return status;
  }

  @JsonProperty("status")
  public void setStatus(String status) {
    this.status = status;
  }

  @JsonProperty("message")
  public String getMessage() {
    return message;
  }

  @JsonProperty("message")
  public void setMessage(String message) {
    this.message = message;
  }

  @JsonProperty("lastUpdated")
  public String getLastUpdated() {
    return lastUpdated;
  }

  @JsonProperty("lastUpdated")
  public void setLastUpdated(String lastUpdated) {
    this.lastUpdated = lastUpdated;
  }

  @JsonProperty("annotations")
  public List<Object> getAnnotations() {
    return annotations;
  }

  @JsonProperty("annotations")
  public void setAnnotations(List<Object> annotations) {
    this.annotations = annotations;
  }

  @JsonProperty("runDimension")
  public RunDimension getRunDimension() {
    return runDimension;
  }

  @JsonProperty("runDimension")
  public void setRunDimension(RunDimension runDimension) {
    this.runDimension = runDimension;
  }

  @JsonProperty("isLatest")
  public Boolean getIsLatest() {
    return isLatest;
  }

  @JsonProperty("isLatest")
  public void setIsLatest(Boolean isLatest) {
    this.isLatest = isLatest;
  }
}