package com.azure.datafactory.pipeline.sink;

import com.azure.datafactory.pipeline.FormatSettings;
import com.azure.datafactory.pipeline.StoreSettings;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonSink extends Sink {
  @JsonProperty("storeSettings")
  private StoreSettings storeSettings;
  @JsonProperty("formatSettings")
  private FormatSettings formatSettings;

  public JsonSink() {}

  private JsonSink(StoreSettings storeSettings, FormatSettings formatSettings, String type) {
    super(type);
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

  public static final class Builder {
    private StoreSettings storeSettings;
    private FormatSettings formatSettings;
    private String type;

    public Builder withType(String type) {
      this.type = type;
      return this;
    }

    public Builder withStoreSettings(StoreSettings storeSettings) {
      this.storeSettings = storeSettings;
      return this;
    }

    public Builder withFormatSettings(FormatSettings formatSettings) {
      this.formatSettings = formatSettings;
      return this;
    }

    public JsonSink createJsonSink() {
      return new JsonSink(storeSettings, formatSettings, type);
    }
  }
}
