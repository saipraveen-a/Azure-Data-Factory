package com.azure.datafactory.pipeline.sink;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.azure.datafactory.pipeline.FormatSettings;
import com.azure.datafactory.pipeline.StoreSettings;

public class DelimitedTextSink extends Sink {
  @JsonProperty("storeSettings")
  private StoreSettings storeSettings;
  @JsonProperty("formatSettings")
  private FormatSettings formatSettings;

  public DelimitedTextSink() {}

  public DelimitedTextSink(StoreSettings storeSettings, FormatSettings formatSettings) {
    this.storeSettings = storeSettings;
    this.formatSettings = formatSettings;
  }

  @JsonProperty("storeSettings")
  public StoreSettings getStoreSettings() {
    return storeSettings;
  }

  @JsonProperty("storeSettings")
  public void setStoreSettings(StoreSettings storeSettings) {
    this.storeSettings = storeSettings;
  }

  @JsonProperty("formatSettings")
  public FormatSettings getFormatSettings() {
    return formatSettings;
  }

  @JsonProperty("formatSettings")
  public void setFormatSettings(FormatSettings formatSettings) {
    this.formatSettings = formatSettings;
  }
}
