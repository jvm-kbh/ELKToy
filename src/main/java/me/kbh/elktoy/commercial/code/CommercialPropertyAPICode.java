package me.kbh.elktoy.commercial.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CommercialPropertyAPICode {
  SEARCH("/_search"),
  TOTAL_COUNT("/commercial_property/_count")
  ;
  private String apiUrl;
}
