package me.kbh.elktoy.commercial.component.elasticsearch.query.bool;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BoolQueryType {
  MUST("must"),
  FILTER("filter");

  private String name;
}
