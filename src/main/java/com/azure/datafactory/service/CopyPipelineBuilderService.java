package com.azure.datafactory.service;

import com.azure.datafactory.pipeline.PipelineParameters;
import com.azure.datafactory.pipeline.PipelineProperties;
import com.azure.datafactory.pipeline.activity.Activity;
import com.azure.datafactory.proxy.DataFactoryProxy;

import java.io.IOException;

public abstract class CopyPipelineBuilderService extends PipelineBuilderService {

  private ActivityBuilderService activityBuilderService;

  public CopyPipelineBuilderService(DataFactoryProxy dataFactoryProxy, ActivityBuilderService activityBuilderService) {
    super(dataFactoryProxy);
    this.activityBuilderService = activityBuilderService;
  }

  @Override
  protected void initPipeline() {

  }

  @Override
  protected PipelineProperties getPipelineProperties() throws IOException {
    Activity activity = activityBuilderService.buildActivity();
    PipelineProperties pipelineProperties = new PipelineProperties();
    pipelineProperties.getActivities().add(activity);
    PipelineParameters pipelineParameters = getPipelineParameters();
    pipelineProperties.setParameters(pipelineParameters);
    return pipelineProperties;
  }

  private PipelineParameters getPipelineParameters() {
    return new PipelineParameters();
  }
}
