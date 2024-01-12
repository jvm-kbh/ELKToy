package me.kbh.elktoy.commercial.dto.response.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class HitSourceDto {
  @JsonProperty("commercialPropertyId")
  private String commercialPropertyId; // 상가업소번호, 이 엔티티의 기본 키

  @JsonProperty("name")
  private String name; // 상호명

  @JsonProperty("branchName")
  private String branchName; // 지점명

  @JsonProperty("majorCategoryCode")
  private String majorCategoryCode; // 상권업종대분류코드

  @JsonProperty("majorCategoryName")
  private String majorCategoryName; // 상권업종대분류명

  @JsonProperty("middleCategoryCode")
  private String middleCategoryCode; // 상권업종중분류코드

  @JsonProperty("middleCategoryName")
  private String middleCategoryName; // 상권업종중분류명

  @JsonProperty("subCategoryCode")
  private String subCategoryCode; // 상권업종소분류코드

  @JsonProperty("subCategoryName")
  private String subCategoryName; // 상권업종소분류명

  @JsonProperty("industryCode")
  private String industryCode; // 표준산업분류코드

  @JsonProperty("industryName")
  private String industryName; // 표준산업분류명

  @JsonProperty("cityCode")
  private String cityCode; // 시도코드

  @JsonProperty("cityName")
  private String cityName; // 시도명

  @JsonProperty("districtCode")
  private String districtCode; // 시군구코드

  @JsonProperty("districtName")
  private String districtName; // 시군구명

  @JsonProperty("administrativeDistrictCode")
  private String administrativeDistrictCode; // 행정동코드

  @JsonProperty("administrativeDistrictName")
  private String administrativeDistrictName; // 행정동명

  @JsonProperty("legalDistrictCode")
  private String legalDistrictCode; // 법정동코드

  @JsonProperty("legalDistrictName")
  private String legalDistrictName; // 법정동명

  @JsonProperty("parcelCode")
  private String parcelCode; // 지번코드

  @JsonProperty("landCategoryCode")
  private String landCategoryCode; // 대지구분코드

  @JsonProperty("landCategoryName")
  private String landCategoryName; // 대지구분명

  @JsonProperty("parcelMainNumber")
  private String parcelMainNumber; // 지번본번지

  @JsonProperty("parcelSubNumber")
  private String parcelSubNumber; // 지번부번지

  @JsonProperty("parcelAddress")
  private String parcelAddress; // 지번주소

  @JsonProperty("roadCode")
  private String roadCode; // 도로명코드

  @JsonProperty("roadName")
  private String roadName; // 도로명

  @JsonProperty("buildingMainNumber")
  private String buildingMainNumber; // 건물본번지

  @JsonProperty("buildingSubNumber")
  private String buildingSubNumber; // 건물부번지

  @JsonProperty("buildingManagementNumber")
  private String buildingManagementNumber; // 건물관리번호

  @JsonProperty("buildingName")
  private String buildingName; // 건물명

  @JsonProperty("roadAddress")
  private String roadAddress; // 도로명주소

  @JsonProperty("oldZipCode")
  private String oldZipCode; // 구우편번호

  @JsonProperty("newZipCode")
  private String newZipCode; // 신우편번호

  @JsonProperty("dongInfo")
  private String dongInfo; // 동정보

  @JsonProperty("floorInfo")
  private String floorInfo; // 층정보

  @JsonProperty("unitInfo")
  private String unitInfo; // 호정보

  @JsonProperty("longitude")
  private String longitude; // 경도

  @JsonProperty("latitude")
  private String latitude; // 위도
}
