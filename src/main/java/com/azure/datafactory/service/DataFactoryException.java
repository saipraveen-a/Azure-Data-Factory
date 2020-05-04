package com.azure.datafactory.service;

public class DataFactoryException extends RuntimeException {

  public DataFactoryException(String message, Throwable ex) {
    super(message, ex);
  }

}
