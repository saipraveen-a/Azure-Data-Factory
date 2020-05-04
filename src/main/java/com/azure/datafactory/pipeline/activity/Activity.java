package com.azure.datafactory.pipeline.activity;

import com.azure.datafactory.linkedservice.LinkedServiceName;
import com.azure.datafactory.pipeline.activity.copy.CopyActivityProperties;
import com.azure.datafactory.pipeline.activity.copy.Input;
import com.azure.datafactory.pipeline.activity.copy.Output;
import com.azure.datafactory.pipeline.activity.usql.UsqlActivityProperties;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Activity {
  @JsonProperty("name")
  private String name;
  @JsonProperty("type")
  private String type;

  @JsonProperty("typeProperties")
  @JsonTypeInfo(
      use = JsonTypeInfo.Id.NAME,
      include = JsonTypeInfo.As.EXTERNAL_PROPERTY,
      property = "type",
      visible = true)
  @JsonSubTypes({
      @JsonSubTypes.Type(value = CopyActivityProperties.class, name = "Copy"),
      @JsonSubTypes.Type(value = UsqlActivityProperties.class, name = "DataLakeAnalyticsU-SQL")})
  private ActivityProperties typeProperties;

  @JsonProperty("inputs")
  private List<Input> inputs = new ArrayList<>();

  @JsonProperty("outputs")
  private List<Output> outputs = new ArrayList<>();

  @JsonProperty("linkedServiceName")
  private LinkedServiceName linkedServiceName;

  @JsonProperty("dependsOn")
  private List<DependsOn> dependsOn = new ArrayList<>();

  public Activity() {}

  public Activity(List<Input> inputs, List<Output> outputs) {
    this.inputs.addAll(inputs);
    this.outputs.addAll(outputs);
  }

  public Activity(LinkedServiceName linkedServiceName) {
    this.linkedServiceName = linkedServiceName;
  }

  @JsonProperty("name")
  public String getName() {
    return name;
  }

  @JsonProperty("name")
  public void setName(String name) {
    this.name = name;
  }

  @JsonProperty("type")
  public String getType() {
    return type;
  }

  @JsonProperty("type")
  public void setType(String type) {
    this.type = type;
  }

  @JsonProperty("typeProperties")
  public ActivityProperties getTypeProperties() {
    return typeProperties;
  }

  @JsonProperty("typeProperties")
  public void setTypeProperties(ActivityProperties typeProperties) {
    this.typeProperties = typeProperties;
  }

  @JsonProperty("inputs")
  public List<Input> getInputs() {
    return inputs;
  }

  @JsonProperty("inputs")
  public void setInputs(List<Input> inputs) {
    this.inputs = inputs;
  }

  @JsonProperty("outputs")
  public List<Output> getOutputs() {
    return outputs;
  }

  @JsonProperty("outputs")
  public void setOutputs(List<Output> outputs) {
    this.outputs = outputs;
  }

  @JsonProperty("dependsOn")
  public List<DependsOn> getDependsOn() {
    return dependsOn;
  }

  @JsonProperty("dependsOn")
  public void setDependsOn(List<DependsOn> dependsOn) {
    this.dependsOn = dependsOn;
  }

  public LinkedServiceName getLinkedServiceName() {
    return linkedServiceName;
  }

  public void setLinkedServiceName(LinkedServiceName linkedServiceName) {
    this.linkedServiceName = linkedServiceName;
  }
}