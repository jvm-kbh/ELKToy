package me.kbh.elktoy.commercial.component.elasticsearch.query;

import lombok.NoArgsConstructor;
import me.kbh.elktoy.commercial.component.elasticsearch.query.bool.BoolQueryBuilder;

@NoArgsConstructor
public class QueryBuilder {
  private QueryType type;
  public String baseQuery = """
    "query" : {%s}
  """;

  public QueryBuilder type(QueryType type){
    this.type = type;
    return this;
  }
  /*public QueryBuilder build(){
    QueryBuilder builder = new BoolQueryBuilder();
    switch (type) {
      case BOOL -> builder = new BoolQueryBuilder();
      default -> throw new IllegalArgumentException("unsupported Query: " + type);
    }
    return builder;
  }*/
}
