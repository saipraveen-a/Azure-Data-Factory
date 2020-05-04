package com.azure.datafactory.service;

import com.azure.datafactory.pipeline.PipelineProperties;
import com.azure.datafactory.pipeline.PipelineRequest;
import com.azure.datafactory.proxy.DataFactoryProxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public abstract class PipelineBuilderService {
  private static final Logger LOGGER = LoggerFactory.getLogger(PipelineBuilderService.class);

  private final DataFactoryProxy dataFactoryProxy;
  private Map<String, Object> contextParams = new HashMap<>();

  public PipelineBuilderService(DataFactoryProxy dataFactoryProxy) {
    this.dataFactoryProxy = dataFactoryProxy;
  }

  public PipelineRequest buildPipeline() throws IOException {
    initPipeline();
    PipelineRequest pipelineRequest = new PipelineRequest();
    pipelineRequest.setProperties(getPipelineProperties());
    return pipelineRequest;
  }

  protected abstract void initPipeline();

  protected abstract PipelineProperties getPipelineProperties() throws IOException;

  public DataFactoryProxy getDataFactoryProxy() {
    return dataFactoryProxy;
  }

  public Map<String, Object> getContextParams() {
    return contextParams;
  }
}
