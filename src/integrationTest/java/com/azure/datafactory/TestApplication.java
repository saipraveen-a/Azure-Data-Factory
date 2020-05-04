package com.azure.datafactory;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestApplication {

  public static final class Profiles {
    public static final String NO_DEPENDENCIES = "no-dependencies";

    public static final String PRODUCTION = "default";

    public static final String DEVELOPMENT = "dev";

    public static final String INTEGRATION = "it";
  }
}
