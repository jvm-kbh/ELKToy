package me.kbh.elktoy.commercial.dto;

import java.util.LinkedHashMap;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import me.kbh.elktoy.commercial.model.CommercialProperty;

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

  @Builder(builderClassName = "ModelMappingBuilder", builderMethodName = "builderByModel", buildMethodName = "modelBuild")
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

  @Builder(builderClassName = "dataMappingBuilder", builderMethodName = "builderByData", buildMethodName = "dataBuild")
  public CommercialPropertyDto(LinkedHashMap<String, Object> hitData) {
    String defaultValue = "--"; // 기본 값

    this.commercialPropertyId = (hitData.get("commercialPropertyId") != null) ? (String) hitData.get("commercialPropertyId") : defaultValue;
    this.name = (hitData.get("name") != null) ? (String) hitData.get("name") : defaultValue;
    this.branchName = (hitData.get("branchName") != null) ? (String) hitData.get("branchName") : defaultValue;
    this.majorCategoryCode = (hitData.get("majorCategoryCode") != null) ? (String) hitData.get("majorCategoryCode") : defaultValue;
    this.majorCategoryName = (hitData.get("majorCategoryName") != null) ? (String) hitData.get("majorCategoryName") : defaultValue;
    this.middleCategoryCode = (hitData.get("middleCategoryCode") != null) ? (String) hitData.get("middleCategoryCode") : defaultValue;
    this.middleCategoryName = (hitData.get("middleCategoryName") != null) ? (String) hitData.get("middleCategoryName") : defaultValue;
    this.subCategoryCode = (hitData.get("subCategoryCode") != null) ? (String) hitData.get("subCategoryCode") : defaultValue;
    this.subCategoryName = (hitData.get("subCategoryName") != null) ? (String) hitData.get("subCategoryName") : defaultValue;
    this.industryCode = (hitData.get("industryCode") != null) ? (String) hitData.get("industryCode") : defaultValue;
    this.industryName = (hitData.get("industryName") != null) ? (String) hitData.get("industryName") : defaultValue;
    this.cityCode = (hitData.get("cityCode") != null) ? (String) hitData.get("cityCode") : defaultValue;
    this.cityName = (hitData.get("cityName") != null) ? (String) hitData.get("cityName") : defaultValue;
    this.districtCode = (hitData.get("districtCode") != null) ? (String) hitData.get("districtCode") : defaultValue;
    this.districtName = (hitData.get("districtName") != null) ? (String) hitData.get("districtName") : defaultValue;
    this.administrativeDistrictCode = (hitData.get("administrativeDistrictCode") != null) ? (String) hitData.get("administrativeDistrictCode") : defaultValue;
    this.administrativeDistrictName = (hitData.get("administrativeDistrictName") != null) ? (String) hitData.get("administrativeDistrictName") : defaultValue;
    this.legalDistrictCode = (hitData.get("legalDistrictCode") != null) ? (String) hitData.get("legalDistrictCode") : defaultValue;
    this.legalDistrictName = (hitData.get("legalDistrictName") != null) ? (String) hitData.get("legalDistrictName") : defaultValue;
    this.parcelCode = (hitData.get("parcelCode") != null) ? (String) hitData.get("parcelCode") : defaultValue;
    this.landCategoryCode = (hitData.get("landCategoryCode") != null) ? (String) hitData.get("landCategoryCode") : defaultValue;
    this.landCategoryName = (hitData.get("landCategoryName") != null) ? (String) hitData.get("landCategoryName") : defaultValue;
    this.parcelMainNumber = (hitData.get("parcelMainNumber") != null) ? (String) hitData.get("parcelMainNumber") : defaultValue;
    this.parcelSubNumber = (hitData.get("parcelSubNumber") != null) ? (String) hitData.get("parcelSubNumber") : defaultValue;
    this.parcelAddress = (hitData.get("parcelAddress") != null) ? (String) hitData.get("parcelAddress") : defaultValue;
    this.roadCode = (hitData.get("roadCode") != null) ? (String) hitData.get("roadCode") : defaultValue;
    this.roadName = (hitData.get("roadName") != null) ? (String) hitData.get("roadName") : defaultValue;
    this.buildingMainNumber = (hitData.get("buildingMainNumber") != null) ? (String) hitData.get("buildingMainNumber") : defaultValue;
    this.buildingSubNumber = (hitData.get("buildingSubNumber") != null) ? (String) hitData.get("buildingSubNumber") : defaultValue;
    this.buildingManagementNumber = (hitData.get("buildingManagementNumber") != null) ? (String) hitData.get("buildingManagementNumber") : defaultValue;
    this.buildingName = (hitData.get("buildingName") != null) ? (String) hitData.get("buildingName") : defaultValue;
    this.roadAddress = (hitData.get("roadAddress") != null) ? (String) hitData.get("roadAddress") : defaultValue;
    this.oldZipCode = (hitData.get("oldZipCode") != null) ? (String) hitData.get("oldZipCode") : defaultValue;
    this.newZipCode = (hitData.get("newZipCode") != null) ? (String) hitData.get("newZipCode") : defaultValue;
    this.dongInfo = (hitData.get("dongInfo") != null) ? (String) hitData.get("dongInfo") : defaultValue;
    this.floorInfo = (hitData.get("floorInfo") != null) ? (String) hitData.get("floorInfo") : defaultValue;
    this.unitInfo = (hitData.get("unitInfo") != null) ? (String) hitData.get("unitInfo") : defaultValue;
    this.longitude = (hitData.get("longitude") != null) ? (String) hitData.get("longitude") : defaultValue;
    this.latitude = (hitData.get("latitude") != null) ? (String) hitData.get("latitude") : defaultValue;
  }
}
