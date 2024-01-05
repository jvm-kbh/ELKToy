package me.kbh.elktoy.commercial.component.elasticsearch.query.bool;

import java.util.HashMap;
import java.util.Map;
import lombok.NoArgsConstructor;
import me.kbh.elktoy.commercial.component.elasticsearch.query.QueryBuilder;

public class BoolQueryBuilder{

  private String baseQuery = """
    "bool" : {%s}
  """;
  private String element = """
    "%s" : {%s}
  """;

  private HashMap<BoolQueryType, String> boolQueryMap = new HashMap<>();
  public String build(){
    return "";
  }
}
