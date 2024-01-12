package me.kbh.elktoy.commercial.dto.aggregation;

import java.util.List;
import java.util.Map;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommercialPropertyAggregation {
  String aggregationTitle;
  List<Map<String, String>> aggregationDataMap;

  @Builder
  public CommercialPropertyAggregation(
      String aggregationTitle, List<Map<String, String>> aggregationDataMap) {
    this.aggregationTitle = aggregationTitle;
    this.aggregationDataMap = aggregationDataMap;
  }
}
