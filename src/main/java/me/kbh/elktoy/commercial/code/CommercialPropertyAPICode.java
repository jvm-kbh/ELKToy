package me.kbh.elktoy.commercial.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CommercialPropertyAPICode {
  SEARCH("/commercial_property/_search"),
  COUNT("/commercial_property/_count");
  private String apiUrl;
}
