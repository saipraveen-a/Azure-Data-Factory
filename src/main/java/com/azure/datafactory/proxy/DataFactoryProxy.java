package com.azure.datafactory.proxy;

import com.azure.datafactory.dataset.Dataset;
import com.azure.datafactory.dataset.DatasetRequest;
import com.azure.datafactory.linkedservice.LinkedService;
import com.azure.datafactory.linkedservice.LinkedServiceRequest;
import com.azure.datafactory.pipeline.Pipeline;
import com.azure.datafactory.pipeline.PipelineRequest;
import com.azure.datafactory.pipeline.PipelineRun;
import com.azure.datafactory.pipeline.PipelineRunId;

import java.io.IOException;
import java.util.Optional;

public interface DataFactoryProxy {

  PipelineRun getPipelineRun(String runId) throws IOException;

  Optional<LinkedService> getLinkedService(String name) throws IOException;

  LinkedService createOrUpdateLinkedService(String name, LinkedServiceRequest linkedServiceRequest) throws IOException;

  Optional<Dataset> getDataset(String name) throws IOException;

  Optional<Pipeline> getPipeline(String name) throws IOException;

  Dataset createOrUpdateDataset(String name, DatasetRequest datasetRequest) throws IOException;

  Pipeline createOrUpdatePipeline(String name, PipelineRequest pipelineRequest) throws IOException;

  PipelineRunId createPipelineRun(String name) throws IOException;

  void deletePipeline(String name) throws IOException;
}
