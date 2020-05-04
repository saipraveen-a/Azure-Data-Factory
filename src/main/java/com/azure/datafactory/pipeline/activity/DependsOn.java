package com.azure.datafactory.pipeline.activity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DependsOn {

  @JsonProperty("activity")
  private String activity;
  @JsonProperty("dependencyConditions")
  private List<String> dependencyConditions = new ArrayList<>();

  public DependsOn() {}

  private DependsOn(String activity, List<String> dependencyConditions) {
    this.activity = activity;
    this.dependencyConditions = dependencyConditions;
  }

  @JsonProperty("activity")
  public String getActivity() {
    return activity;
  }

  @JsonProperty("activity")
  public void setActivity(String activity) {
    this.activity = activity;
  }

  @JsonProperty("dependencyConditions")
  public List<String> getDependencyConditions() {
    return dependencyConditions;
  }

  @JsonProperty("dependencyConditions")
  public void setDependencyConditions(List<String> dependencyConditions) {
    this.dependencyConditions = dependencyConditions;
  }

  public static final class Builder {
    private String activity;
    private List<String> dependencyConditions = new ArrayList<>();

    public Builder withActivity(String activity) {
      this.activity = activity;
      return this;
    }

    public Builder withDependencyConditions(List<String> dependencyConditions) {
      this.dependencyConditions.addAll(dependencyConditions);
      return this;
    }

    public DependsOn createDependsOn() {
      return new DependsOn(activity, dependencyConditions);
    }
  }
}