package com.azure.datafactory.service;

import com.azure.datafactory.dataset.Dataset;
import com.azure.datafactory.dataset.DatasetProperties;
import com.azure.datafactory.dataset.DatasetRequest;
import com.azure.datafactory.linkedservice.LinkedService;
import com.azure.datafactory.linkedservice.LinkedServiceRequest;
import com.azure.datafactory.pipeline.activity.Activity;
import com.azure.datafactory.pipeline.activity.ActivityProperties;
import com.azure.datafactory.pipeline.activity.ActivityType;
import com.azure.datafactory.pipeline.activity.copy.CopyActivity;
import com.azure.datafactory.pipeline.activity.copy.CopyActivityProperties;
import com.azure.datafactory.pipeline.activity.copy.Input;
import com.azure.datafactory.pipeline.activity.copy.Output;
import com.azure.datafactory.pipeline.sink.Sink;
import com.azure.datafactory.pipeline.source.Source;
import com.azure.datafactory.proxy.DataFactoryProxy;

import java.io.IOException;
import java.util.Optional;

public abstract class CopyActivityBuilderService extends ActivityBuilderService {

  public CopyActivityBuilderService(DataFactoryProxy dataFactoryProxy) {
    super(dataFactoryProxy);
  }

  @Override
  protected Activity getActivity() throws IOException {
    return getCopyActivity();
  }

  private Activity getCopyActivity() throws IOException {
    Activity activity = new CopyActivity.Builder()
        .withInput(getInput())
        .withOutput(getOutput())
        .createCopyActivity();
    activity.setName(getActivityName());
    activity.setType(ActivityType.COPY.getType());
    activity.setTypeProperties(getActivityProperties());
    return activity;
  }

  private Output getOutput() throws IOException {
    Optional<Dataset> datasetOptional = getDataFactoryProxy().getDataset(getOutputDatasetName());
    Output output = new Output();
    output.setType("DatasetReference");
    if (datasetOptional.isPresent()) {
      output.setReferenceName(datasetOptional.get().getName());
    } else {
      Dataset dataset = getDataFactoryProxy().createOrUpdateDataset(getOutputDatasetName(), getOutputDatasetRequest());
      output.setReferenceName(dataset.getName());
    }

    return output;
  }

  private DatasetRequest getOutputDatasetRequest() throws IOException {
    Optional<LinkedService> linkedServiceOptional =
        getDataFactoryProxy().getLinkedService(getOutputLinkedServiceName());

    if (!linkedServiceOptional.isPresent()) {
      getDataFactoryProxy().createOrUpdateLinkedService(getOutputLinkedServiceName(), getOutputLinkedServiceRequest());
    }

    DatasetRequest datasetRequest = new DatasetRequest();
    datasetRequest.setDatasetProperties(getOutputDatasetProperties());
    datasetRequest.setSchema(getOutputDatasetSchema());
    return datasetRequest;
  }

  protected abstract String getOutputDatasetSchema() throws IOException;

  private Input getInput() throws IOException {
    Optional<Dataset> datasetOptional = getDataFactoryProxy().getDataset(getInputDatasetName());
    Input input = new Input();
    input.setType("DatasetReference");

    if (datasetOptional.isPresent()) {
      input.setReferenceName(datasetOptional.get().getName());
    } else {
      Dataset dataset = getDataFactoryProxy().createOrUpdateDataset(getInputDatasetName(), getInputDatasetRequest());
      input.setReferenceName(dataset.getName());
    }
    return input;
  }

  private DatasetRequest getInputDatasetRequest() throws IOException {
    Optional<LinkedService> linkedServiceOptional = getDataFactoryProxy().getLinkedService(getInputLinkedServiceName());

    if (!linkedServiceOptional.isPresent()) {
      getDataFactoryProxy().createOrUpdateLinkedService(getInputLinkedServiceName(), getInputLinkedServiceRequest());
    }

    DatasetRequest datasetRequest = new DatasetRequest();
    datasetRequest.setDatasetProperties(getInputDatasetProperties());
    datasetRequest.setSchema(getInputDatasetSchema());
    return datasetRequest;
  }

  protected abstract String getInputDatasetSchema();

  private ActivityProperties getActivityProperties() {
    ActivityProperties activityProperties = new CopyActivityProperties.Builder()
        .withSource(getSource())
        .withSink(getSink())
        .createCopyActivityProperties();
    return activityProperties;
  }

  @Override
  protected void initActivity() {

  }

  protected abstract String getActivityName();

  protected abstract String getInputLinkedServiceName();

  protected abstract LinkedServiceRequest getInputLinkedServiceRequest();

  protected abstract String getOutputLinkedServiceName();

  protected abstract LinkedServiceRequest getOutputLinkedServiceRequest();

  protected abstract String getInputDatasetName();

  protected abstract String getOutputDatasetName();

  protected abstract DatasetProperties getInputDatasetProperties();

  protected abstract DatasetProperties getOutputDatasetProperties();

  protected abstract Sink getSink();

  protected abstract Source getSource();
}
