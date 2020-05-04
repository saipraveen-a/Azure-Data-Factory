package com.azure.datafactory.proxy;

import com.azure.datafactory.configuration.settings.DataFactorySettings;
import org.springframework.web.util.UriComponentsBuilder;

public class RestDataFactoryConfiguration {
  public static final String LINKED_SERVICE_URL = "/linkedservices/{name}";
  public static final String DATA_SET_URL = "/datasets/{name}";
  public static final String PIPELINE_URL = "/pipelines/{name}";
  public static final String PIPELINE_CREATE_RUN_URL = "/pipelines/{name}/createRun";
  public static final String PIPELINE_RUN_URL = "/pipelineruns/{id}";

  public static final String PARAMETER_API_VERSION = "api-version";

  private DataFactorySettings dataFactorySettings;

  public RestDataFactoryConfiguration(DataFactorySettings dataFactorySettings) {
    this.dataFactorySettings = dataFactorySettings;
  }

  public String getLinkedServiceUrl(String name) {

    return UriComponentsBuilder
        .fromHttpUrl(dataFactorySettings.getBaseUrl())
        .path(LINKED_SERVICE_URL)
        .queryParam(PARAMETER_API_VERSION, dataFactorySettings.getApiVersion())
        .buildAndExpand(name)
        .toUriString();
  }

  public String getDatasetUrl(String name) {

    return UriComponentsBuilder
        .fromHttpUrl(dataFactorySettings.getBaseUrl())
        .path(DATA_SET_URL)
        .queryParam(PARAMETER_API_VERSION, dataFactorySettings.getApiVersion())
        .buildAndExpand(name)
        .toUriString();
  }

  public String getPipelineUrl(String name) {

    return UriComponentsBuilder
        .fromHttpUrl(dataFactorySettings.getBaseUrl())
        .path(PIPELINE_URL)
        .queryParam(PARAMETER_API_VERSION, dataFactorySettings.getApiVersion())
        .buildAndExpand(name)
        .toUriString();
  }

  public String createPipelineRunUrl(String name) {

    return UriComponentsBuilder
        .fromHttpUrl(dataFactorySettings.getBaseUrl())
        .path(PIPELINE_CREATE_RUN_URL)
        .queryParam(PARAMETER_API_VERSION, dataFactorySettings.getApiVersion())
        .buildAndExpand(name)
        .toUriString();
  }

  public String getPipelineRunUrl(String runId) {

    return UriComponentsBuilder
        .fromHttpUrl(dataFactorySettings.getBaseUrl())
        .path(PIPELINE_RUN_URL)
        .queryParam(PARAMETER_API_VERSION, dataFactorySettings.getApiVersion())
        .buildAndExpand(runId)
        .toUriString();
  }
}
