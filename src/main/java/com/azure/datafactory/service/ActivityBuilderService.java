package com.azure.datafactory.service;

import com.azure.datafactory.pipeline.activity.Activity;
import com.azure.datafactory.proxy.DataFactoryProxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public abstract class ActivityBuilderService {
  private static final Logger LOGGER = LoggerFactory.getLogger(ActivityBuilderService.class);

  private final DataFactoryProxy dataFactoryProxy;
  private Map<String, Object> contextParams = new HashMap<>();

  public ActivityBuilderService(DataFactoryProxy dataFactoryProxy) {
    this.dataFactoryProxy = dataFactoryProxy;
  }

  public Activity buildActivity() throws IOException {
    initActivity();
    return getActivity();
  }

  protected abstract void initActivity() throws IOException;

  protected abstract Activity getActivity() throws IOException;

  public DataFactoryProxy getDataFactoryProxy() {
    return dataFactoryProxy;
  }

  public Map<String, Object> getContextParams() {
    return contextParams;
  }
}
