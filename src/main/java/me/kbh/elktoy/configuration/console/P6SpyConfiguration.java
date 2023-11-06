package me.kbh.elktoy.configuration.console;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class P6SpyConfiguration {

  @Bean
  public P6SpyEventListener p6SpyCustomEventListener() {
    return new P6SpyEventListener();
  }

  @Bean
  public P6SpyFormatter p6SpyCustomFormatter() {
    return new P6SpyFormatter();
  }
}
