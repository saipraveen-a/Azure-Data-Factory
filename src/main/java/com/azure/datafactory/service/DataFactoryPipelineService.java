package com.azure.datafactory.service;

import com.azure.datafactory.pipeline.Pipeline;
import com.azure.datafactory.pipeline.PipelineRequest;
import com.azure.datafactory.pipeline.PipelineRun;
import com.azure.datafactory.pipeline.PipelineRunId;
import com.azure.datafactory.proxy.DataFactoryProxy;

import com.github.rholder.retry.RetryException;
import com.github.rholder.retry.Retryer;
import com.github.rholder.retry.RetryerBuilder;
import com.github.rholder.retry.StopStrategies;
import com.github.rholder.retry.WaitStrategies;
import org.apache.http.client.ClientProtocolException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class DataFactoryPipelineService {
  private static final Logger LOGGER = LoggerFactory.getLogger(DataFactoryPipelineService.class);

  private final DataFactoryProxy dataFactoryProxy;
  private Retryer<String> retryer = RetryerBuilder
      .<String>newBuilder()
      .retryIfResult(pipelineRunStatus -> Objects.equals(pipelineRunStatus, PipelineRunStatus.INPROGRESS.getStatus()))
      .retryIfExceptionOfType(ClientProtocolException.class)
      .retryIfExceptionOfType(IOException.class)
      .withWaitStrategy(WaitStrategies.fibonacciWait())
      .withStopStrategy(StopStrategies.stopAfterDelay(20, TimeUnit.MINUTES))
      .build();

  public DataFactoryPipelineService(DataFactoryProxy dataFactoryProxy) {
    this.dataFactoryProxy = dataFactoryProxy;
  }

  public Pipeline createPipeline(String name, PipelineRequest pipelineRequest) throws IOException {
    try {
      Pipeline pipeline = dataFactoryProxy.createOrUpdatePipeline(name, pipelineRequest);
      return pipeline;
    } catch (IOException e) {
      LOGGER.error("Exception while creating pipeline", e);
      throw e;
    }
  }

  public void deletePipeline(String name) throws IOException {
    try {
      dataFactoryProxy.deletePipeline(name);
    } catch (IOException e) {
      LOGGER.error("Exception while deleteing pipeline", e);
      throw e;
    }
  }

  public PipelineRun triggerPipelineRun(String name) throws IOException {
    try {
      PipelineRunId pipelineRunId = dataFactoryProxy.createPipelineRun(name);
      return dataFactoryProxy.getPipelineRun(pipelineRunId.getRunId());
    } catch (IOException e) {
      LOGGER.error("Exception while creating pipeline", e);
      throw e;
    }
  }

  public PipelineRun triggerPipelineRunAndWait(String name) throws IOException {
    try {
      PipelineRunId pipelineRunId = dataFactoryProxy.createPipelineRun(name);
      retryer.call(new Callable<String>() {
        public String call() throws Exception {

          PipelineRun pipelineRun = dataFactoryProxy.getPipelineRun(pipelineRunId.getRunId());
          return pipelineRun.getStatus();
        }
      });
      return dataFactoryProxy.getPipelineRun(pipelineRunId.getRunId());
    } catch (RetryException | ExecutionException e) {
      LOGGER.error("Failed to get Pipeline Run", e);
      throw new RuntimeException("Exception while getting Pipeline Run", e);
    } catch (IOException e) {
      LOGGER.error("Exception while creating pipeline", e);
      throw e;
    }
  }

  public Optional<Pipeline> getPipeline(String name) throws IOException {
    try {
      return dataFactoryProxy.getPipeline(name);
    } catch (IOException e) {
      LOGGER.error("Exception while creating pipeline", e);
      throw e;
    }
  }
}
