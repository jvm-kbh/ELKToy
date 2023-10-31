package me.kbh.elktoy.configuration.elasticsearch;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;

//https://docs.spring.io/spring-data/elasticsearch/reference/migration-guides/migration-guide-4.4-5.0.html

@Configuration
public class ElasticClientConfiguration extends ElasticsearchConfiguration {

  @Override
  public ClientConfiguration clientConfiguration() {
    return ClientConfiguration.builder() //
        .connectedTo("localhost:9200") //
        .build();
  }
}