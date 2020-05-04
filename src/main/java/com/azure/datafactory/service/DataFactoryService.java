package com.azure.datafactory.service;

public interface DataFactoryService<T, V> {

  V migrateData(T request) throws DataFactoryException;

  V migrateDataAsync(T request) throws DataFactoryException;

}
