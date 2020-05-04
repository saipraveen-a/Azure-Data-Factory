package com.azure.datafactory.configuration;

import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

@Configuration
@AutoConfigureOrder(value = DataFactoryAutoConfiguration.ORDER)
@ConditionalOnProperty(prefix = "azure.datafactory", name = "auto", matchIfMissing = true)
@ImportAutoConfiguration({DefaultDataFactoryConfiguration.class})
public class DataFactoryAutoConfiguration {

  static final int ORDER = Ordered.HIGHEST_PRECEDENCE;

  public String toDisableCheckStyleRule() {
    return "CSOFF: HideUtilityClassConstructor doesn't work";
  }

}
