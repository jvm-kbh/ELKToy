package me.kbh.elktoy.commercial.component.elasticsearch.query.bool.template;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public enum BoolQueryTemplate {
  GEO("""
  {
    "geo_distance": {
      "distance": "%dkm",
      "location": {
        "lat": %f,
        "lon": %f
      }
    }
  }
  """),
  NAME("""
  {
    "wildcard": {
      "name.keyword": {
        "value": "*%s*"
      }
    }
  }
  """),
  CATEGORY("""
  {
    "match": {
      "%sCategoryCode": "%s"
    }
  }
  """);

  private String template;
}
