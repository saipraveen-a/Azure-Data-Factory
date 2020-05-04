package com.azure.datafactory.service;

import com.azure.datafactory.linkedservice.LinkedServiceName;
import com.azure.datafactory.pipeline.activity.Activity;
import com.azure.datafactory.pipeline.activity.ActivityProperties;
import com.azure.datafactory.pipeline.activity.ActivityType;
import com.azure.datafactory.pipeline.activity.usql.ScriptLinkedService;
import com.azure.datafactory.pipeline.activity.usql.UsqlActivity;
import com.azure.datafactory.pipeline.activity.usql.UsqlActivityProperties;
import com.azure.datafactory.proxy.DataFactoryProxy;

import java.io.IOException;

public abstract class UsqlActivityBuilderService extends ActivityBuilderService {

  public UsqlActivityBuilderService(DataFactoryProxy dataFactoryProxy) {
    super(dataFactoryProxy);
  }

  @Override
  protected Activity getActivity() throws IOException {
    return getUsqlActivity();
  }

  private Activity getUsqlActivity() throws IOException {
    Activity activity = new UsqlActivity.Builder()
        .withLinkedServiceName(getDataLakeLinkedService())
        .createUsqlActivity();
    activity.setName(getActivityName());
    activity.setType(ActivityType.USQL.getType());
    activity.setTypeProperties(getActivityProperties());
    return activity;
  }

  private LinkedServiceName getDataLakeLinkedService() {
    return new LinkedServiceName.Builder()
        .withType("LinkedServiceReference")
        .withReferenceName(getDataLakeLinkedServiceName())
        .createLinkedServiceName();
  }

  protected abstract String getDataLakeLinkedServiceName();

  private ActivityProperties getActivityProperties() {
    ActivityProperties activityProperties = new UsqlActivityProperties.Builder()
        .withScriptPath(getUsqlScriptPath())
        .withScriptLinkedService(getUsqlScriptLinkedService())
        .createUsqlActivityProperties();
    return activityProperties;
  }

  protected abstract String getActivityName();

  protected abstract String getUsqlScriptPath();

  protected abstract ScriptLinkedService getUsqlScriptLinkedService();
}
