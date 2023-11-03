package me.kbh.elktoy.commercial.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import me.kbh.elktoy.commercial.document.CommercialProperty;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommercialPropertyDto {
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
  int parcelMainNumber; // 지번본번지
  int parcelSubNumber; // 지번부번지
  String parcelAddress; // 지번주소
  String roadCode; // 도로명코드
  String roadName; // 도로명
  int buildingMainNumber; // 건물본번지
  int buildingSubNumber; // 건물부번지
  String buildingManagementNumber; // 건물관리번호
  String buildingName; // 건물명
  String roadAddress; // 도로명주소
  String oldZipCode; // 구우편번호
  String newZipCode; // 신우편번호
  String dongInfo; // 동정보
  String floorInfo; // 층정보
  String unitInfo; // 호정보
  double longitude; // 경도
  double latitude; // 위도

  @Builder
  public CommercialPropertyDto(CommercialProperty toDocument) {
    this.commercialPropertyId = toDocument.getCommercialPropertyId();
    this.name = toDocument.getName();
    this.branchName = toDocument.getBranchName();
    this.majorCategoryCode = toDocument.getMajorCategoryCode();
    this.majorCategoryName = toDocument.getMajorCategoryName();
    this.middleCategoryCode = toDocument.getMiddleCategoryCode();
    this.middleCategoryName = toDocument.getMiddleCategoryName();
    this.subCategoryCode = toDocument.getSubCategoryCode();
    this.subCategoryName = toDocument.getSubCategoryName();
    this.industryCode = toDocument.getIndustryCode();
    this.industryName = toDocument.getIndustryName();
    this.cityCode = toDocument.getCityCode();
    this.cityName = toDocument.getCityName();
    this.districtCode = toDocument.getDistrictCode();
    this.districtName = toDocument.getDistrictName();
    this.administrativeDistrictCode = toDocument.getAdministrativeDistrictCode();
    this.administrativeDistrictName = toDocument.getAdministrativeDistrictName();
    this.legalDistrictCode = toDocument.getLegalDistrictCode();
    this.legalDistrictName = toDocument.getLegalDistrictName();
    this.parcelCode = toDocument.getParcelCode();
    this.landCategoryCode = toDocument.getLandCategoryCode();
    this.landCategoryName = toDocument.getLandCategoryName();
    this.parcelMainNumber = toDocument.getParcelMainNumber();
    this.parcelSubNumber = toDocument.getParcelSubNumber();
    this.parcelAddress = toDocument.getParcelAddress();
    this.roadCode = toDocument.getRoadCode();
    this.roadName = toDocument.getRoadName();
    this.buildingMainNumber = toDocument.getBuildingMainNumber();
    this.buildingSubNumber = toDocument.getBuildingSubNumber();
    this.buildingManagementNumber = toDocument.getBuildingManagementNumber();
    this.buildingName = toDocument.getBuildingName();
    this.roadAddress = toDocument.getRoadAddress();
    this.oldZipCode = toDocument.getOldZipCode();
    this.newZipCode = toDocument.getNewZipCode();
    this.dongInfo = toDocument.getDongInfo();
    this.floorInfo = toDocument.getFloorInfo();
    this.unitInfo = toDocument.getUnitInfo();
    this.longitude = toDocument.getLongitude();
    this.latitude = toDocument.getLatitude();
  }
}
