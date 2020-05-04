package com.azure.datafactory;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import com.azure.datafactory.configuration.settings.DataFactorySettings;
import com.azure.datafactory.configuration.settings.GoogleBigQuerySettings;
import com.azure.datafactory.dataset.DatasetRequest;
import com.azure.datafactory.dataset.LinkedServiceName;
import com.azure.datafactory.dataset.cosmos.DocumentDbDatasetProperties;
import com.azure.datafactory.dataset.cosmos.DocumentDbTypeProperties;
import com.azure.datafactory.linkedservice.LinkedServiceRequest;
import com.azure.datafactory.linkedservice.LinkedServiceRequestProperties;
import com.azure.datafactory.linkedservice.SecretValue;
import com.azure.datafactory.linkedservice.bigquery.request.BigQueryLinkedServiceRequestProperties;
import com.azure.datafactory.linkedservice.bigquery.request.BigQueryRequestTypeProperties;
import com.azure.datafactory.pipeline.FormatSettings;
import com.azure.datafactory.pipeline.PipelineParameters;
import com.azure.datafactory.pipeline.PipelineProperties;
import com.azure.datafactory.pipeline.PipelineRequest;
import com.azure.datafactory.pipeline.PipelineRun;
import com.azure.datafactory.pipeline.PipelineRunId;
import com.azure.datafactory.pipeline.StoreSettings;
import com.azure.datafactory.pipeline.activity.Activity;
import com.azure.datafactory.pipeline.activity.ActivityProperties;
import com.azure.datafactory.pipeline.activity.copy.CopyActivity;
import com.azure.datafactory.pipeline.activity.copy.CopyActivityProperties;
import com.azure.datafactory.pipeline.activity.copy.Input;
import com.azure.datafactory.pipeline.activity.copy.Output;
import com.azure.datafactory.pipeline.sink.JsonSink;
import com.azure.datafactory.pipeline.sink.Sink;
import com.azure.datafactory.pipeline.sink.SinkType;
import com.azure.datafactory.pipeline.source.DocumentDbCollectionSource;
import com.azure.datafactory.pipeline.source.Source;
import com.azure.datafactory.pipeline.source.SourceType;
import com.azure.datafactory.proxy.RestDataFactoryProxy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = TestApplication.class)
@ActiveProfiles(TestApplication.Profiles.NO_DEPENDENCIES)
public class ApplicationIntegrationTest {

  @Autowired
  private TestApplication application;

  @Autowired
  private RestDataFactoryProxy restDataFactoryProxy;

  @Autowired
  private DataFactorySettings dataFactorySettings;

  @Autowired
  private GoogleBigQuerySettings bigQueryConfiguration;

  @Test
  public void launch_thenApplicationIsStarted() {
    assertThat(application, is(not(nullValue())));
  }

  @Test
  public void getLinkedServiceTest() throws Exception {
    System.out.println("Invoking Data factory to get Linked Service");
    restDataFactoryProxy.getLinkedService("cosmosLinkedService");
  }

  @Test
  public void createOrUpdateLinkedServiceTest() throws Exception {
    System.out.println("Invoking Data factory to create or update Linked Service");

    LinkedServiceRequest linkedServiceRequest = getBigQueryLinkedServiceCreateOrUpdateRequest();

    restDataFactoryProxy.createOrUpdateLinkedService("bigqueryLinkedService", linkedServiceRequest);
  }

  @Test
  public void getDatasetTest() throws Exception {
    System.out.println("Invoking Data factory to get Data Set");
    restDataFactoryProxy.getDataset("ds_out_adls");
  }

  @Test
  public void createOrUpdateDatasetTest() throws Exception {
    System.out.println("Invoking Data factory to create or update Data Set");

    DatasetRequest datasetRequest = getCosmosDocumentDbDatasetRequest();

    restDataFactoryProxy.createOrUpdateDataset("ds_in", datasetRequest);
  }

  @Test
  public void getPipelineTest() throws Exception {
    System.out.println("Invoking Data factory to get Pipeline");
    restDataFactoryProxy.getPipeline("copyPipeline");
  }

  @Test
  public void createOrUpdatePipelineTest() throws Exception {
    System.out.println("Invoking Data factory to create or update Pipeline");

    PipelineRequest pipelineRequest = getCopyFromCosmosToBlobStorePipelineRequest();

    restDataFactoryProxy.createOrUpdatePipeline("copyPipeline", pipelineRequest);
  }

  @Test
  public void createPipelineRunTest() throws Exception {
    System.out.println("Invoking Data factory to create or update Pipeline");

    PipelineRunId pipelineRunId = restDataFactoryProxy.createPipelineRun("copyPipeline");
    PipelineRun pipelineRun = restDataFactoryProxy.getPipelineRun(pipelineRunId.getRunId());

    assertThat(pipelineRun, is(notNullValue()));
  }

  private LinkedServiceRequest getBigQueryLinkedServiceCreateOrUpdateRequest() {
    BigQueryLinkedServiceRequestProperties bigQueryLinkedServiceRequestProperties =
        new BigQueryLinkedServiceRequestProperties.Builder()
            .withTypeProperties(getBigQueryRequestTypeProperties())
            .createBigQueryLinkedServiceRequestProperties();

    LinkedServiceRequestProperties linkedServiceRequestProperties = bigQueryLinkedServiceRequestProperties;
    LinkedServiceRequest linkedServiceRequest = new LinkedServiceRequest(linkedServiceRequestProperties);
    return linkedServiceRequest;
  }

  private DatasetRequest getCosmosDocumentDbDatasetRequest() {
    DocumentDbTypeProperties typeProperties = new DocumentDbTypeProperties.Builder()
        .withCollectionName("ProductHierarchyMember")
        .createDocumentDbTypeProperties();
    LinkedServiceName linkedServiceName = new LinkedServiceName.Builder()
        .withType("LinkedServiceReference")
        .withReferenceName("cosmosLinkedService")
        .createLinkedServiceName();

    DocumentDbDatasetProperties documentDbDatasetProperties = new DocumentDbDatasetProperties.Builder()
        .withTypeProperties(typeProperties)
        .withType("DocumentDbCollection")
        .withLinkedServiceName(linkedServiceName)
        .createDocumentDbDatasetProperties();
    DatasetRequest datasetRequest = new DatasetRequest();
    datasetRequest.setDatasetProperties(documentDbDatasetProperties);

    return datasetRequest;
  }

  private BigQueryRequestTypeProperties getBigQueryRequestTypeProperties() {
    SecretValue clientId = new SecretValue.Builder()
        .withType("SecureString")
        .withValue(bigQueryConfiguration.getClientId())
        .createSecretValue();
    SecretValue clientSecret = new SecretValue.Builder()
        .withType("SecureString")
        .withValue(bigQueryConfiguration.getClientSecret())
        .createSecretValue();
    SecretValue refreshToken = new SecretValue.Builder()
        .withType("SecureString")
        .withValue(bigQueryConfiguration.getRefreshToken())
        .createSecretValue();

    BigQueryRequestTypeProperties bigQueryRequestTypeProperties =
        new BigQueryRequestTypeProperties.Builder()
            .withProject(bigQueryConfiguration.getDefaultProjectId())
            .withAuthenticationType(bigQueryConfiguration.getAuthenticationType())
            .withClientId(clientId)
            .withClientSecret(clientSecret)
            .withRefreshToken(refreshToken)
            .createBigQueryRequestTypeProperties();

    return bigQueryRequestTypeProperties;
  }


  private PipelineRequest getCopyFromCosmosToBlobStorePipelineRequest() {
    PipelineRequest pipelineRequest = new PipelineRequest();

    PipelineProperties pipelineProperties = getPipelineProperties();
    pipelineRequest.setProperties(pipelineProperties);

    return pipelineRequest;
  }

  private PipelineProperties getPipelineProperties() {
    PipelineProperties properties = new PipelineProperties();
    Activity copyActivity = getCopyFromCosmosToBlobStoreActivity();
    properties.setActivities(Arrays.asList(copyActivity));
    properties.setParameters(new PipelineParameters());

    return properties;
  }

  private Activity getCopyFromCosmosToBlobStoreActivity() {
    Input input = new Input();
    input.setType("DatasetReference");
    input.setReferenceName("ds_in");

    Output output = new Output();
    output.setType("DatasetReference");
    output.setReferenceName("ds_out");

    Activity activity = new CopyActivity.Builder()
        .withInput(input)
        .withOutput(output)
        .createCopyActivity();

    Source source = new DocumentDbCollectionSource();
    source.setType(SourceType.DOCUMENTDBCOLLECTION.getType());

    StoreSettings storeSettings = new StoreSettings();
    storeSettings.setType("AzureBlobStorageWriteSettings");
    FormatSettings formatSettings = new FormatSettings();
    formatSettings.setType("JsonWriteSettings");

    Sink sink = new JsonSink.Builder()
        .withStoreSettings(storeSettings)
        .withFormatSettings(formatSettings)
        .createJsonSink();
    sink.setType(SinkType.JSON.getType());

    ActivityProperties activityProperties = new CopyActivityProperties.Builder()
        .withSource(source)
        .withSink(sink)
        .createCopyActivityProperties();
    activity.setName("copyActivity");
    activity.setType("Copy");
    activity.setTypeProperties(activityProperties);

    return activity;
  }
}
