package com.azure.datafactory.pipeline;

import static java.util.Arrays.asList;

import com.azure.datafactory.pipeline.activity.Activity;
import com.azure.datafactory.pipeline.activity.DependsOn;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PipelineProperties {

  @JsonProperty("activities")
  private List<Activity> activities = new ArrayList<>();
  @JsonProperty("parameters")
  private PipelineParameters parameters;

  @JsonProperty("activities")
  public List<Activity> getActivities() {
    return activities;
  }

  @JsonProperty("activities")
  public void setActivities(List<Activity> activities) {
    this.activities = activities;
  }

  public void addActivity(Activity activity) {
    this.activities.add(activity);
  }

  public void addChainedActivity(Activity activity) {
    Activity lastActivity = this.activities.get(activities.size() - 1);
    activity.getDependsOn().add(new DependsOn.Builder()
        .withActivity(lastActivity.getName())
        .withDependencyConditions(asList("Succeeded"))
        .createDependsOn());
    this.activities.add(activity);
  }

  public void addChainedActivity(List<Activity> dependentActivities, Activity activity) {
    dependentActivities.stream().map(dependentActivity -> activity.getDependsOn().add(
        new DependsOn.Builder()
            .withActivity(dependentActivity.getName())
            .withDependencyConditions(asList("Succeeded"))
            .createDependsOn()
    ));
    this.activities.add(activity);
  }

  @JsonProperty("parameters")
  public PipelineParameters getParameters() {
    return parameters;
  }

  @JsonProperty("parameters")
  public void setParameters(PipelineParameters parameters) {
    this.parameters = parameters;
  }
}