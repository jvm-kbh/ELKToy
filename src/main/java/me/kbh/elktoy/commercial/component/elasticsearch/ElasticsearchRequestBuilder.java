package me.kbh.elktoy.commercial.component.elasticsearch;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import me.kbh.elktoy.commercial.code.CommercialPropertyColumCode;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ElasticsearchRequestBuilder {

  private String root = "{%s}";
  private String jsonBody =
      """
                          "from": %d,
                          "size": %d,
                          "_source": [ %s ],
                          %s
      """;
  private int from;
  private int size;
  private String source;


  @Builder
  public ElasticsearchRequestBuilder(int from, int size, String source) {
    this.from = from;
    if (size == 0){
      this.size = 10;
    } else {
      this.size = size;
    }
    this.source = source;
  }

  public String buildJsonBody() {
    jsonBody =
        jsonBody.formatted(
            (from - 1) * size,
            size,
            source,
            "query"
        );

    return root.formatted(jsonBody);
  }

  private boolean isFirst() {
    return jsonBody.equals("{}");
  }
}
