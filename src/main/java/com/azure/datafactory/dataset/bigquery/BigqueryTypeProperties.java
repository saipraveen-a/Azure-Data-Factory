package com.azure.datafactory.dataset.bigquery;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BigqueryTypeProperties {

  @JsonProperty("table")
  private String table;

  @JsonProperty("dataset")
  private String dataset;

  public BigqueryTypeProperties() {}

  private BigqueryTypeProperties(String dataset, String table) {
    this.table = table;
    this.dataset = dataset;
  }

  @JsonProperty("table")
  public String getTable() {
    return table;
  }

  @JsonProperty("table")
  public void setTable(String table) {
    this.table = table;
  }

  @JsonProperty("dataset")
  public String getDataset() {
    return dataset;
  }

  @JsonProperty("dataset")
  public void setDataset(String table) {
    this.dataset = dataset;
  }

  public static class Builder {
    private String table;
    private String dataset;

    public Builder withTable(String table) {
      this.table = table;
      return this;
    }

    public Builder withDataset(String dataset) {
      this.dataset = dataset;
      return this;
    }

    public BigqueryTypeProperties createBigqueryTypeProperties() {
      return new BigqueryTypeProperties(dataset, table);
    }
  }
}
