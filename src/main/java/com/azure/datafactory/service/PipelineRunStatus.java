package com.azure.datafactory.service;

public enum PipelineRunStatus {
  SUCCEEDED("Succeeded"),
  INPROGRESS("InProgress"),
  FAILED("Failed");

  private String status;

  PipelineRunStatus(String status) {
    this.status = status;
  }

  public String getStatus() {
    return status;
  }
}
