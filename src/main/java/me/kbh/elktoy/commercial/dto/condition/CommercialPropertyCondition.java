package me.kbh.elktoy.commercial.dto.condition;

import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommercialPropertyCondition {
  String name; // 상호명
  String majorCategoryCode; // 상권업종대분류코드
  String majorCategoryName; // 상권업종대분류명
  String middleCategoryCode; // 상권업종중분류코드
  String middleCategoryName; // 상권업종중분류명
  String subCategoryCode; // 상권업종소분류코드
  String subCategoryName; // 상권업종소분류명

  String industryCode; // 표준산업분류코드
  String industryName; // 표준산업분류명

  String longitude; // 경도
  String latitude; // 위도

}
