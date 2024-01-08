package me.kbh.elktoy.commercial.dto.condition;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class CommercialPropertySearchCondition {
  String searchName;
  double lat;
  double lot;
  int from;
  String selectedAggregationType;
  String seledtedAggregationName;
}
