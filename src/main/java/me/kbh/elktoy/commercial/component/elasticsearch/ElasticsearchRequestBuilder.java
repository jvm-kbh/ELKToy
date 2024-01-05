package me.kbh.elktoy.commercial.component.elasticsearch;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class ElasticsearchRequestBuilder {
  private String jsonBody = "{}";
  Map<RequestBodyType, Object> requestMap = new HashMap<>();

  public String buildJsonBody() {
    return "".formatted();
  }
}
