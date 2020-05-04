package com.azure.datafactory.authorization;

import com.azure.datafactory.configuration.settings.DataFactorySettings;
import com.azure.datafactory.utils.EncoderUtil;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.common.base.Preconditions;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class AuthTokenProvider {
  private static final Logger LOGGER = LoggerFactory.getLogger(AuthTokenProvider.class);
  private static final String AUTHORIZATION_TYPE = "Basic";

  private final DataFactorySettings dataFactorySettings;
  private final CloseableHttpClient httpClient;
  private final PoolingHttpClientConnectionManager poolingHttpClientConnectionManager;

  public AuthTokenProvider(
      DataFactorySettings dataFactorySettings,
      CloseableHttpClient httpClient,
      PoolingHttpClientConnectionManager poolingHttpClientConnectionManager) {
    this.dataFactorySettings = dataFactorySettings;
    this.httpClient = httpClient;
    this.poolingHttpClientConnectionManager = poolingHttpClientConnectionManager;
  }

  public AzureAccessToken getAccessToken() throws IOException {
    CloseableHttpResponse response = null;
    try {
      LOGGER.info("Connection Pool Manager stats: " + poolingHttpClientConnectionManager.getTotalStats());
      String clientId = dataFactorySettings.getClientId();
      String clientSecret = dataFactorySettings.getClientSecret();
      Preconditions.checkState(StringUtils.isNotBlank(clientId), "clientId cannot be empty");
      Preconditions.checkState(StringUtils.isNotBlank(clientSecret), "clientSecret cannot be empty");

      String userCredentials = String.format("%s:%s", clientId, clientSecret);
      String basicAuth = String.format("%s %s", AUTHORIZATION_TYPE,
          EncoderUtil.getBase64EncodedString(userCredentials));

      HttpPost post = buildPostForAuthorization(basicAuth, dataFactorySettings);
      response = httpClient.execute(post);
      String accessTokenJson = IOUtils.toString(response.getEntity().getContent(), "UTF-8");
      Gson gson = new Gson();
      return gson.fromJson(accessTokenJson, AzureAccessToken.class);
    } finally {
      if (response != null) {
        response.close();
      }
    }
  }

  private HttpPost buildPostForAuthorization(String basicAuth, DataFactorySettings dataFactorySettings) throws UnsupportedEncodingException {
    HttpPost post = new HttpPost(dataFactorySettings.getAuthorizationUrl());

    post.setHeader("Authorization", basicAuth);
    post.setHeader("Content-Type", "application/x-www-form-urlencoded");

    List<NameValuePair> urlParameters = new ArrayList<>();

    urlParameters.add(new BasicNameValuePair("grant_type", "client_credentials"));
    urlParameters.add(new BasicNameValuePair("client_id", dataFactorySettings.getClientId()));
    urlParameters.add(new BasicNameValuePair("client_secret", dataFactorySettings.getClientSecret()));
    urlParameters.add(new BasicNameValuePair("resource", dataFactorySettings.getResource()));
    post.setEntity(new UrlEncodedFormEntity(urlParameters));

    return post;
  }
}
