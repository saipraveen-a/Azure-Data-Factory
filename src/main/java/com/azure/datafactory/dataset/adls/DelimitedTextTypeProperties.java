package com.azure.datafactory.dataset.adls;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DelimitedTextTypeProperties {

  @JsonProperty("columnDelimiter")
  private String columnDelimiter;

  @JsonProperty("quoteChar")
  private String quoteChar;

  @JsonProperty("escapeChar")
  private String escapeChar;

  @JsonProperty("firstRowAsHeader")
  private Boolean firstRowAsHeader;

  @JsonProperty("location")
  private AzureDataLakeStoreLocation location;

  public DelimitedTextTypeProperties() {}

  private DelimitedTextTypeProperties(String columnDelimiter, String quoteChar,
                                      String escapeChar, Boolean firstRowAsHeader,
                                      AzureDataLakeStoreLocation location) {
    this.columnDelimiter = columnDelimiter;
    this.quoteChar = quoteChar;
    this.escapeChar = escapeChar;
    this.firstRowAsHeader = firstRowAsHeader;
    this.location = location;
  }

  @JsonProperty("columnDelimiter")
  public String getColumnDelimiter() {
    return columnDelimiter;
  }

  @JsonProperty("columnDelimiter")
  public void setColumnDelimiter(String table) {
    this.columnDelimiter = columnDelimiter;
  }

  @JsonProperty("quoteChar")
  public String getQuoteChar() {
    return quoteChar;
  }

  @JsonProperty("quoteChar")
  public void setQuoteChar(String table) {
    this.quoteChar = quoteChar;
  }

  @JsonProperty("escapeChar")
  public String getEscapeChar() {
    return escapeChar;
  }

  @JsonProperty("escapeChar")
  public void setEscapeChar(String escapeChar) {
    this.escapeChar = escapeChar;
  }

  @JsonProperty("firstRowAsHeader")
  public Boolean getFirstRowAsHeader() {
    return firstRowAsHeader;
  }

  @JsonProperty("firstRowAsHeader")
  public void setFirstRowAsHeader(Boolean firstRowAsHeader) {
    this.firstRowAsHeader = firstRowAsHeader;
  }

  @JsonProperty("location")
  public AzureDataLakeStoreLocation getLocation() {
    return location;
  }

  @JsonProperty("location")
  public void setLocation(AzureDataLakeStoreLocation location) {
    this.location = location;
  }

  public static class Builder {
    private String columnDelimiter;
    private String quoteChar;
    private String escapeChar;
    private Boolean firstRowAsHeader;
    private AzureDataLakeStoreLocation location;

    public Builder withColumnDelimiter(String columnDelimiter) {
      this.columnDelimiter = columnDelimiter;
      return this;
    }

    public Builder withQuoteChar(String quoteChar) {
      this.quoteChar = quoteChar;
      return this;
    }

    public Builder withEscapeChar(String escapeChar) {
      this.escapeChar = escapeChar;
      return this;
    }

    public Builder withFirstRowAsHeader(Boolean firstRowAsHeader) {
      this.firstRowAsHeader = firstRowAsHeader;
      return this;
    }

    public Builder withAzureDataLakeStoreLocation(AzureDataLakeStoreLocation location) {
      this.location = location;
      return this;
    }

    public DelimitedTextTypeProperties createDelimitedTextTypeProperties() {
      return new DelimitedTextTypeProperties(columnDelimiter, quoteChar, escapeChar, firstRowAsHeader, location);
    }
  }
}
