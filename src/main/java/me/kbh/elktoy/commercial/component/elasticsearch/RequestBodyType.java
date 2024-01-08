package me.kbh.elktoy.commercial.component.elasticsearch;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RequestBodyType {
  FROM("from"),
  SIZE("size"),
  QUERY("query"),
  AGGREGATION("aggs");

  private String name;
}
