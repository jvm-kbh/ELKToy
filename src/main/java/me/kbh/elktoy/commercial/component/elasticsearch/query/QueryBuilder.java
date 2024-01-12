package me.kbh.elktoy.commercial.component.elasticsearch.query;

import me.kbh.elktoy.commercial.component.elasticsearch.query.bool.BoolQuery;
import me.kbh.elktoy.commercial.component.elasticsearch.query.bool.BoolQuery.BoolQueryBuilder;

public abstract class QueryBuilder {
  private QueryType type;
  public String baseQuery = """
    "query" : {%s}
  """;

  public static BoolQueryBuilder chooseType(QueryType type) {
    switch (type) {
      case BOOL:
        return BoolQuery.builder();
      default:
        throw new IllegalArgumentException("Unsupported query type");
    }
  }
}
