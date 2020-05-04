package com.azure.datafactory.pipeline.activity.usql;

import com.azure.datafactory.linkedservice.LinkedServiceName;
import com.azure.datafactory.pipeline.activity.Activity;

import com.fasterxml.jackson.annotation.JsonProperty;


public class UsqlActivity extends Activity {
  @JsonProperty("linkedServiceName")
  private LinkedServiceName linkedServiceName;

  public UsqlActivity() { }

  private UsqlActivity(LinkedServiceName linkedServiceName) {
    super(linkedServiceName);
    this.linkedServiceName = linkedServiceName;
  }

  @Override
  public LinkedServiceName getLinkedServiceName() {
    return linkedServiceName;
  }

  @Override
  public void setLinkedServiceName(LinkedServiceName linkedServiceName) {
    this.linkedServiceName = linkedServiceName;
  }

  public static final class Builder {
    private LinkedServiceName linkedServiceName;

    public Builder withLinkedServiceName(LinkedServiceName linkedServiceName) {
      this.linkedServiceName = linkedServiceName;
      return this;
    }

    public UsqlActivity createUsqlActivity() {
      return new UsqlActivity(linkedServiceName);
    }
  }
}
