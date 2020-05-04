package com.azure.datafactory.utils.json;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;


// CSOFF: HideUtilityClassConstructor
public class DefaultJsonConfiguration {

  private static final ObjectMapper OBJECT_MAPPER = //
      new ObjectMapper() //
          .registerModule(new JavaTimeModule())
          .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
              .disable(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE);

  public static ObjectMapper getObjectMapper() {
    return OBJECT_MAPPER;
  }
}
