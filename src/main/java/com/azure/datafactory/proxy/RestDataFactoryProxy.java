package com.azure.datafactory.proxy;

import com.azure.datafactory.authorization.AuthTokenProvider;
import com.azure.datafactory.authorization.AzureAccessToken;
import com.azure.datafactory.dataset.Dataset;
import com.azure.datafactory.dataset.DatasetRequest;
import com.azure.datafactory.linkedservice.LinkedService;
import com.azure.datafactory.linkedservice.LinkedServiceRequest;
import com.azure.datafactory.pipeline.Pipeline;
import com.azure.datafactory.pipeline.PipelineRequest;
import com.azure.datafactory.pipeline.PipelineRun;
import com.azure.datafactory.pipeline.PipelineRunId;
import com.azure.datafactory.utils.json.DefaultJsonConfiguration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Optional;

public class RestDataFactoryProxy implements DataFactoryProxy {
  private static final Logger LOGGER = LoggerFactory.getLogger(RestDataFactoryProxy.class);
  private static final ObjectMapper OBJECT_MAPPER = DefaultJsonConfiguration.getObjectMapper();

  private final CloseableHttpClient httpClient;
  private final AuthTokenProvider authTokenProvider;
  private final PoolingHttpClientConnectionManager poolingHttpClientConnectionManager;
  private final RestDataFactoryConfiguration configuration;

  public RestDataFactoryProxy(
      CloseableHttpClient httpClient,
      AuthTokenProvider authTokenProvider,
      PoolingHttpClientConnectionManager poolingHttpClientConnectionManager,
      RestDataFactoryConfiguration configuration) {
    this.httpClient = httpClient;
    this.authTokenProvider = authTokenProvider;
    this.poolingHttpClientConnectionManager = poolingHttpClientConnectionManager;
    this.configuration = configuration;
  }

  //CSOFF: IllegalCatch
  @Override
  public Optional<LinkedService> getLinkedService(String name) throws IOException {
    LOGGER.debug("Connection Pool Manager Stats: " + poolingHttpClientConnectionManager.getTotalStats());
    LinkedService linkedService = null;
    try {
      AzureAccessToken accessToken = authTokenProvider.getAccessToken();
      HttpGet get = buildGetRequest(accessToken, configuration.getLinkedServiceUrl(name));
      CloseableHttpResponse response = httpClient.execute(get);

      LOGGER.debug("Response Code For Api Call: " + configuration.getLinkedServiceUrl(name) + " is "
          + response.getStatusLine().getStatusCode());
      if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
        linkedService = OBJECT_MAPPER.readValue(response.getEntity().getContent(), LinkedService.class);
      }
      return linkedService == null ? Optional.empty() : Optional.of(linkedService);
    } catch (Exception e) {
      LOGGER.error("Exception while getting linked service", e);
      throw e;
    }
  }

  @Override
  public LinkedService createOrUpdateLinkedService(
      String name,
      LinkedServiceRequest linkedServiceRequest) throws IOException {
    LOGGER.debug("Connection Pool Manager Stats: " + poolingHttpClientConnectionManager.getTotalStats());
    try {
      AzureAccessToken accessToken = authTokenProvider.getAccessToken();
      HttpPut put = buildCreateOrUpdateLinkedServiceRequest(accessToken, configuration.getLinkedServiceUrl(name), linkedServiceRequest);
      CloseableHttpResponse response = httpClient.execute(put);

      LOGGER.debug("Response Code For Api Call: " + configuration.getLinkedServiceUrl(name) + " is "
          + response.getStatusLine().getStatusCode());
      LinkedService linkedService = OBJECT_MAPPER.readValue(response.getEntity().getContent(), LinkedService.class);
      return linkedService;
    } catch (Exception e) {
      LOGGER.error("Exception while getting linked service", e);
      throw e;
    }
  }

  @Override
  public Optional<Dataset> getDataset(String name) throws IOException {
    LOGGER.debug("Connection Pool Manager Stats: " + poolingHttpClientConnectionManager.getTotalStats());
    Dataset dataset = null;
    try {
      AzureAccessToken accessToken = authTokenProvider.getAccessToken();
      HttpGet get = buildGetRequest(accessToken, configuration.getDatasetUrl(name));
      CloseableHttpResponse response = httpClient.execute(get);

      LOGGER.debug("Response Code For Api Call: " + configuration.getDatasetUrl(name) + " is "
          + response.getStatusLine().getStatusCode());
      if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
        dataset = OBJECT_MAPPER.readValue(response.getEntity().getContent(), Dataset.class);
      }
      return dataset == null ? Optional.empty() : Optional.of(dataset);
    } catch (Exception e) {
      LOGGER.error("Exception while getting data set", e);
      throw e;
    }
  }

  @Override
  public Dataset createOrUpdateDataset(String name, DatasetRequest datasetRequest) throws IOException {
    LOGGER.debug("Connection Pool Manager Stats: " + poolingHttpClientConnectionManager.getTotalStats());
    try {
      AzureAccessToken accessToken = authTokenProvider.getAccessToken();
      HttpPut put = buildCreateOrUpdateDatasetRequest(accessToken, configuration.getDatasetUrl(name),
          datasetRequest);

      CloseableHttpResponse response = httpClient.execute(put);

      LOGGER.debug("Response Code For Api Call: " + configuration.getDatasetUrl(name) + " is "
          + response.getStatusLine().getStatusCode());
      Dataset dataset = OBJECT_MAPPER.readValue(response.getEntity().getContent(), Dataset.class);
      return dataset;
    } catch (Exception e) {
      LOGGER.error("Exception while updating dataset", e);
      throw e;
    }
  }
  //CSON: IllegalCatch

  @Override
  public Optional<Pipeline> getPipeline(String name) throws IOException {
    LOGGER.debug("Connection Pool Manager Stats: " + poolingHttpClientConnectionManager.getTotalStats());
    Pipeline pipeline = null;
    try {
      AzureAccessToken accessToken = authTokenProvider.getAccessToken();
      HttpGet get = buildGetRequest(accessToken, configuration.getPipelineUrl(name));
      CloseableHttpResponse response = httpClient.execute(get);

      LOGGER.debug("Response Code For Api Call: " + configuration.getPipelineUrl(name) + " is "
          + response.getStatusLine().getStatusCode());
      if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
        pipeline = OBJECT_MAPPER.readValue(response.getEntity().getContent(), Pipeline.class);
      }
      return pipeline == null ? Optional.empty() : Optional.of(pipeline);
    } catch (Exception e) {
      LOGGER.error("Exception while getting pipeline", e);
      throw e;
    }
  }

  @Override
  public Pipeline createOrUpdatePipeline(String name, PipelineRequest pipelineRequest) throws IOException {
    LOGGER.debug("Connection Pool Manager Stats: " + poolingHttpClientConnectionManager.getTotalStats());
    try {
      AzureAccessToken accessToken = authTokenProvider.getAccessToken();
      HttpPut put = buildCreateOrUpdatePipelineRequest(accessToken, configuration.getPipelineUrl(name), pipelineRequest);
      CloseableHttpResponse response = httpClient.execute(put);

      LOGGER.debug("Response Code For Api Call: " + configuration.getPipelineUrl(name) + " is "
          + response.getStatusLine().getStatusCode());
      Pipeline pipeline = OBJECT_MAPPER.readValue(response.getEntity().getContent(), Pipeline.class);
      return pipeline;
    } catch (Exception e) {
      LOGGER.error("Exception while getting pipeline", e);
      throw e;
    }
  }

  @Override
  public PipelineRunId createPipelineRun(String name) throws IOException {
    LOGGER.debug("Connection Pool Manager Stats: " + poolingHttpClientConnectionManager.getTotalStats());
    try {
      AzureAccessToken accessToken = authTokenProvider.getAccessToken();
      HttpPost post = buildCreatePipelineRunRequest(accessToken, configuration.createPipelineRunUrl(name));
      CloseableHttpResponse response = httpClient.execute(post);

      LOGGER.debug("Response Code For Api Call: " + configuration.getPipelineUrl(name) + " is "
          + response.getStatusLine().getStatusCode());
      PipelineRunId pipelineRun = OBJECT_MAPPER.readValue(response.getEntity().getContent(), PipelineRunId.class);
      return pipelineRun;
    } catch (Exception e) {
      LOGGER.error("Exception while getting pipeline", e);
      throw e;
    }
  }

  @Override
  public PipelineRun getPipelineRun(String runId) throws IOException {
    LOGGER.debug("Connection Pool Manager Stats: " + poolingHttpClientConnectionManager.getTotalStats());
    try {
      AzureAccessToken accessToken = authTokenProvider.getAccessToken();
      HttpGet get = buildGetRequest(accessToken, configuration.getPipelineRunUrl(runId));
      CloseableHttpResponse response = httpClient.execute(get);

      LOGGER.debug("Response Code For Api Call: " + configuration.getPipelineRunUrl(runId) + " is "
          + response.getStatusLine().getStatusCode());
      PipelineRun pipelineRun = OBJECT_MAPPER.readValue(response.getEntity().getContent(), PipelineRun.class);
      return pipelineRun;
    } catch (Exception e) {
      LOGGER.error("Exception while getting pipeline run", e);
      throw e;
    }
  }

  @Override
  public void deletePipeline(String name) throws IOException {
    LOGGER.debug("Connection Pool Manager Stats: " + poolingHttpClientConnectionManager.getTotalStats());
    try {
      AzureAccessToken accessToken = authTokenProvider.getAccessToken();
      HttpDelete delete = buildDeleteRequest(accessToken, configuration.getPipelineUrl(name));
      CloseableHttpResponse response = httpClient.execute(delete);

      LOGGER.debug("Response Code For Api Call DELETE: " + configuration.getPipelineRunUrl(name) + " is "
          + response.getStatusLine().getStatusCode());
    } catch (Exception e) {
      LOGGER.error("Exception while getting pipeline run", e);
      throw e;
    }
  }

  private HttpGet buildGetRequest(AzureAccessToken accessToken, String url) {

    HttpGet get = new HttpGet(url);

    get.setHeader("Authorization", String.format("%s %s", "Bearer", accessToken.getAccessToken()));
    get.setHeader("Content-Type", "application/json");

    return get;
  }

  private HttpDelete buildDeleteRequest(AzureAccessToken accessToken, String url) {

    HttpDelete delete = new HttpDelete(url);

    delete.setHeader("Authorization", String.format("%s %s", "Bearer", accessToken.getAccessToken()));

    return delete;
  }

  private HttpPut buildCreateOrUpdateLinkedServiceRequest(
      AzureAccessToken accessToken, String url,
      LinkedServiceRequest linkedServiceRequest) throws JsonProcessingException {

    HttpPut put = new HttpPut(url);

    put.setHeader("Authorization", String.format("%s %s", "Bearer", accessToken.getAccessToken()));
    put.setHeader("Content-Type", "application/json");
    put.setHeader("Accept", "application/json; charset=utf-8");

    String requestJson = OBJECT_MAPPER.writeValueAsString(linkedServiceRequest);
    StringEntity entity = new StringEntity(requestJson, "UTF-8");
    entity.setContentType("application/json");
    put.setEntity(entity);

    return put;
  }

  private HttpPut buildCreateOrUpdateDatasetRequest(
      AzureAccessToken accessToken, String url,
      DatasetRequest datasetRequest) throws JsonProcessingException {

    HttpPut put = new HttpPut(url);

    put.setHeader("Authorization", String.format("%s %s", "Bearer", accessToken.getAccessToken()));
    put.setHeader("Content-Type", "application/json");
    put.setHeader("Accept", "application/json; charset=utf-8");

    String requestJson = OBJECT_MAPPER.writeValueAsString(datasetRequest);
    StringEntity entity = new StringEntity(requestJson, "UTF-8");
    entity.setContentType("application/json");
    put.setEntity(entity);

    return put;
  }

  private HttpPut buildCreateOrUpdatePipelineRequest(
      AzureAccessToken accessToken, String url,
      PipelineRequest pipelineRequest) throws JsonProcessingException {

    HttpPut put = new HttpPut(url);

    put.setHeader("Authorization", String.format("%s %s", "Bearer", accessToken.getAccessToken()));
    put.setHeader("Content-Type", "application/json");
    put.setHeader("Accept", "application/json; charset=utf-8");

    String requestJson = OBJECT_MAPPER.writeValueAsString(pipelineRequest);
    StringEntity entity = new StringEntity(requestJson, "UTF-8");
    entity.setContentType("application/json");
    put.setEntity(entity);

    return put;
  }

  private HttpPost buildCreatePipelineRunRequest(AzureAccessToken accessToken, String url) throws JsonProcessingException {

    HttpPost post = new HttpPost(url);

    post.setHeader("Authorization", String.format("%s %s", "Bearer", accessToken.getAccessToken()));
    post.setHeader("Accept", "application/json; charset=utf-8");

    return post;
  }
}
