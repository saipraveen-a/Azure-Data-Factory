package com.azure.datafactory.pipeline.activity;

public enum ActivityType {
  COPY("Copy"),
  USQL("DataLakeAnalyticsU-SQL");
  private String type;

  ActivityType(String type) {
    this.type = type;
  }

  public String getType() {
    return type;
  }
}
