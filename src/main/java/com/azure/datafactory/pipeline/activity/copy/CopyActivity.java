package com.azure.datafactory.pipeline.activity.copy;

import static java.util.Arrays.asList;

import com.azure.datafactory.pipeline.activity.Activity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class CopyActivity extends Activity {
  @JsonProperty("inputs")
  private List<Input> inputs = new ArrayList<>();
  @JsonProperty("outputs")
  private List<Output> outputs = new ArrayList<>();

  private CopyActivity(List<Input> inputs, List<Output> outputs) {
    super(inputs, outputs);
    this.inputs.addAll(inputs);
    this.outputs.addAll(outputs);
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

  public static final class Builder {
    private List<Input> inputs = new ArrayList<>();
    private List<Output> outputs = new ArrayList<>();

    public Builder withInput(Input input) {
      this.inputs.addAll(asList(input));
      return this;
    }

    public Builder withInputs(List<Input> inputs) {
      this.inputs.addAll(inputs);
      return this;
    }

    public Builder withOutput(Output output) {
      this.outputs.addAll(asList(output));
      return this;
    }

    public Builder withOutputs(List<Output> outputs) {
      this.outputs.addAll(outputs);
      return this;
    }

    public CopyActivity createCopyActivity() {
      return new CopyActivity(inputs, outputs);
    }
  }
}
