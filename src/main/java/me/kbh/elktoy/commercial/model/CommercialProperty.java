package me.kbh.elktoy.commercial.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommercialProperty {
  String commercialPropertyId; // 상가업소번호, 이 엔티티의 기본 키
  String name; // 상호명
  String branchName; // 지점명
  String majorCategoryCode; // 상권업종대분류코드
  String majorCategoryName; // 상권업종대분류명
  String middleCategoryCode; // 상권업종중분류코드
  String middleCategoryName; // 상권업종중분류명
  String subCategoryCode; // 상권업종소분류코드
  String subCategoryName; // 상권업종소분류명
  String industryCode; // 표준산업분류코드
  String industryName; // 표준산업분류명
  String cityCode; // 시도코드
  String cityName; // 시도명
  String districtCode; // 시군구코드
  String districtName; // 시군구명
  String administrativeDistrictCode; // 행정동코드
  String administrativeDistrictName; // 행정동명
  String legalDistrictCode; // 법정동코드
  String legalDistrictName; // 법정동명
  String parcelCode; // 지번코드
  String landCategoryCode; // 대지구분코드
  String landCategoryName; // 대지구분명
  String parcelMainNumber; // 지번본번지
  String parcelSubNumber; // 지번부번지
  String parcelAddress; // 지번주소
  String roadCode; // 도로명코드
  String roadName; // 도로명
  String buildingMainNumber; // 건물본번지
  String buildingSubNumber; // 건물부번지
  String buildingManagementNumber; // 건물관리번호
  String buildingName; // 건물명
  String roadAddress; // 도로명주소
  String oldZipCode; // 구우편번호
  String newZipCode; // 신우편번호
  String dongInfo; // 동정보
  String floorInfo; // 층정보
  String unitInfo; // 호정보
  String longitude; // 경도
  String latitude; // 위도
}
