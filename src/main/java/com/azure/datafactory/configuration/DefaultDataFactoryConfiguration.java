package com.azure.datafactory.configuration;

import com.azure.datafactory.authorization.AuthTokenProvider;
import com.azure.datafactory.configuration.settings.DataFactorySettings;
import com.azure.datafactory.proxy.DataFactoryProxy;
import com.azure.datafactory.proxy.RestDataFactoryConfiguration;
import com.azure.datafactory.proxy.RestDataFactoryProxy;
import com.azure.datafactory.service.DataFactoryPipelineService;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DefaultDataFactoryConfiguration {
  private static final int MAX_TOTAL_CONNECTIONS = 25;
  private static final int MAX_CONNECTIONS_PER_ROUTE = 5;
  private static final int CONNECTION_REQUEST_TIMEOUT_MILLIS = 3000;
  private static final int CONNECT_TIMEOUT_MILLIS = 5000;
  private static final int SOCKET_TIMEOUT_MILLIS = 1200000;

  @Bean
  @ConditionalOnMissingBean
  public PoolingHttpClientConnectionManager poolingHttpClientConnectionManager() {
    PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
    connectionManager.setMaxTotal(MAX_TOTAL_CONNECTIONS);
    connectionManager.setDefaultMaxPerRoute(MAX_CONNECTIONS_PER_ROUTE);

    return connectionManager;
  }

  @Bean
  @ConditionalOnMissingBean
  public CloseableHttpClient httpClient() {
    RequestConfig requestConfig = RequestConfig
        .custom()
        .setConnectionRequestTimeout(CONNECTION_REQUEST_TIMEOUT_MILLIS)
        .setConnectTimeout(CONNECT_TIMEOUT_MILLIS)
        .setSocketTimeout(SOCKET_TIMEOUT_MILLIS)
        .build();

    CloseableHttpClient httpClient = HttpClientBuilder
        .create()
        .disableRedirectHandling()
        .setConnectionManager(poolingHttpClientConnectionManager())
        .setConnectionManagerShared(true)
        .setDefaultRequestConfig(requestConfig)
        .build();

    return httpClient;
  }

  @Bean
  @ConditionalOnMissingBean
  @ConditionalOnBean (value = {DataFactorySettings.class, CloseableHttpClient.class,
      PoolingHttpClientConnectionManager.class })
  public AuthTokenProvider authTokenProvider(DataFactorySettings dataFactorySettings,
                                             CloseableHttpClient httpClient,
                                             PoolingHttpClientConnectionManager poolingHttpClientConnectionManager) {
    return new AuthTokenProvider(dataFactorySettings, httpClient, poolingHttpClientConnectionManager);
  }

  @Bean
  @ConditionalOnMissingBean
  public DataFactorySettings dataFactorySettings() {
    return new DataFactorySettings();
  }

  @Bean
  @ConditionalOnMissingBean
  @ConditionalOnBean (value = {DataFactorySettings.class })
  public RestDataFactoryConfiguration restDataFactoryConfiguration(DataFactorySettings dataFactorySettings) {
    return new RestDataFactoryConfiguration(dataFactorySettings);
  }

  @Bean
  @ConditionalOnMissingBean
  @ConditionalOnBean (value = {CloseableHttpClient.class, AuthTokenProvider.class,
      PoolingHttpClientConnectionManager.class, RestDataFactoryConfiguration.class })
  public RestDataFactoryProxy restDataFactoryProxy(
      CloseableHttpClient httpClient,
      AuthTokenProvider authTokenProvider,
      PoolingHttpClientConnectionManager poolingHttpClientConnectionManager,
      RestDataFactoryConfiguration configuration) {
    return new RestDataFactoryProxy(httpClient, authTokenProvider, poolingHttpClientConnectionManager, configuration);
  }

  @Bean
  @ConditionalOnMissingBean
  @ConditionalOnBean (value = {DataFactoryProxy.class})
  public DataFactoryPipelineService dataFactoryPipelineService(DataFactoryProxy dataFactoryProxy) {
    return new DataFactoryPipelineService(dataFactoryProxy);
  }
}
