package me.kbh.elktoy.commercial.dto.response.aggregation;

import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import me.kbh.elktoy.commercial.dto.aggregation.CommercialPropertyAggregation;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommercialPropertyAggregationResponse {
  List<CommercialPropertyAggregation> commercialPropertyAggregationList;

  @Builder
  public CommercialPropertyAggregationResponse(
      List<CommercialPropertyAggregation> commercialPropertyAggregationList) {
    this.commercialPropertyAggregationList = commercialPropertyAggregationList;
  }
}
