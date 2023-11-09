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
  public CommercialPropertyDto(LinkedHashMap<String, Object> indexData) {
    String defaultValue = "--"; // 기본 값

    this.commercialPropertyId = (indexData.get("commercialPropertyId") != null) ? (String) indexData.get("commercialPropertyId") : defaultValue;
    this.name = (indexData.get("name") != null) ? (String) indexData.get("name") : defaultValue;
    this.branchName = (indexData.get("branchName") != null) ? (String) indexData.get("branchName") : defaultValue;
    this.majorCategoryCode = (indexData.get("majorCategoryCode") != null) ? (String) indexData.get("majorCategoryCode") : defaultValue;
    this.majorCategoryName = (indexData.get("majorCategoryName") != null) ? (String) indexData.get("majorCategoryName") : defaultValue;
    this.middleCategoryCode = (indexData.get("middleCategoryCode") != null) ? (String) indexData.get("middleCategoryCode") : defaultValue;
    this.middleCategoryName = (indexData.get("middleCategoryName") != null) ? (String) indexData.get("middleCategoryName") : defaultValue;
    this.subCategoryCode = (indexData.get("subCategoryCode") != null) ? (String) indexData.get("subCategoryCode") : defaultValue;
    this.subCategoryName = (indexData.get("subCategoryName") != null) ? (String) indexData.get("subCategoryName") : defaultValue;
    this.industryCode = (indexData.get("industryCode") != null) ? (String) indexData.get("industryCode") : defaultValue;
    this.industryName = (indexData.get("industryName") != null) ? (String) indexData.get("industryName") : defaultValue;
    this.cityCode = (indexData.get("cityCode") != null) ? (String) indexData.get("cityCode") : defaultValue;
    this.cityName = (indexData.get("cityName") != null) ? (String) indexData.get("cityName") : defaultValue;
    this.districtCode = (indexData.get("districtCode") != null) ? (String) indexData.get("districtCode") : defaultValue;
    this.districtName = (indexData.get("districtName") != null) ? (String) indexData.get("districtName") : defaultValue;
    this.administrativeDistrictCode = (indexData.get("administrativeDistrictCode") != null) ? (String) indexData.get("administrativeDistrictCode") : defaultValue;
    this.administrativeDistrictName = (indexData.get("administrativeDistrictName") != null) ? (String) indexData.get("administrativeDistrictName") : defaultValue;
    this.legalDistrictCode = (indexData.get("legalDistrictCode") != null) ? (String) indexData.get("legalDistrictCode") : defaultValue;
    this.legalDistrictName = (indexData.get("legalDistrictName") != null) ? (String) indexData.get("legalDistrictName") : defaultValue;
    this.parcelCode = (indexData.get("parcelCode") != null) ? (String) indexData.get("parcelCode") : defaultValue;
    this.landCategoryCode = (indexData.get("landCategoryCode") != null) ? (String) indexData.get("landCategoryCode") : defaultValue;
    this.landCategoryName = (indexData.get("landCategoryName") != null) ? (String) indexData.get("landCategoryName") : defaultValue;
    this.parcelMainNumber = (indexData.get("parcelMainNumber") != null) ? (String) indexData.get("parcelMainNumber") : defaultValue;
    this.parcelSubNumber = (indexData.get("parcelSubNumber") != null) ? (String) indexData.get("parcelSubNumber") : defaultValue;
    this.parcelAddress = (indexData.get("parcelAddress") != null) ? (String) indexData.get("parcelAddress") : defaultValue;
    this.roadCode = (indexData.get("roadCode") != null) ? (String) indexData.get("roadCode") : defaultValue;
    this.roadName = (indexData.get("roadName") != null) ? (String) indexData.get("roadName") : defaultValue;
    this.buildingMainNumber = (indexData.get("buildingMainNumber") != null) ? (String) indexData.get("buildingMainNumber") : defaultValue;
    this.buildingSubNumber = (indexData.get("buildingSubNumber") != null) ? (String) indexData.get("buildingSubNumber") : defaultValue;
    this.buildingManagementNumber = (indexData.get("buildingManagementNumber") != null) ? (String) indexData.get("buildingManagementNumber") : defaultValue;
    this.buildingName = (indexData.get("buildingName") != null) ? (String) indexData.get("buildingName") : defaultValue;
    this.roadAddress = (indexData.get("roadAddress") != null) ? (String) indexData.get("roadAddress") : defaultValue;
    this.oldZipCode = (indexData.get("oldZipCode") != null) ? (String) indexData.get("oldZipCode") : defaultValue;
    this.newZipCode = (indexData.get("newZipCode") != null) ? (String) indexData.get("newZipCode") : defaultValue;
    this.dongInfo = (indexData.get("dongInfo") != null) ? (String) indexData.get("dongInfo") : defaultValue;
    this.floorInfo = (indexData.get("floorInfo") != null) ? (String) indexData.get("floorInfo") : defaultValue;
    this.unitInfo = (indexData.get("unitInfo") != null) ? (String) indexData.get("unitInfo") : defaultValue;
    this.longitude = (indexData.get("longitude") != null) ? (String) indexData.get("longitude") : defaultValue;
    this.latitude = (indexData.get("latitude") != null) ? (String) indexData.get("latitude") : defaultValue;
  }
}
