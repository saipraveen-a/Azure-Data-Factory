package com.azure.datafactory.pipeline.source;

public enum SourceType {
  DOCUMENTDBCOLLECTION("DocumentDbCollectionSource"),
  GOOGLE_BIGQUERY_SOURCE("GoogleBigQuerySource");

  private String type;

  SourceType(String type) {
    this.type = type;
  }

  public String getType() {
    return type;
  }
}
