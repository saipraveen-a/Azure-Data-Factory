package com.azure.datafactory.pipeline.source;

public class DocumentDbCollectionSource extends Source {
  public DocumentDbCollectionSource() {
    super(SourceType.DOCUMENTDBCOLLECTION.getType());
  }
}