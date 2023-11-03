package me.kbh.elktoy.commercial.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CommercialPropertyFieldCode {
  COMMERCIAL_PROPERTY_ID("commercialPropertyId"),
  NAME("name"),
  BRANCH_NAME("branchName"),
  MAJOR_CATEGORY_CODE("majorCategoryCode"),
  MAJOR_CATEGORY_NAME("majorCategoryName"),
  MIDDLE_CATEGORY_CODE("middleCategoryCode"),
  MIDDLE_CATEGORY_NAME("middleCategoryName"),
  SUB_CATEGORY_CODE("subCategoryCode"),
  SUB_CATEGORY_NAME("subCategoryName"),
  INDUSTRY_CODE("industryCode"),
  INDUSTRY_NAME("industryName"),
  CITY_CODE("cityCode"),
  CITY_NAME("cityName"),
  DISTRICT_CODE("districtCode"),
  DISTRICT_NAME("districtName"),
  ADMINISTRATIVE_DISTRICT_CODE("administrativeDistrictCode"),
  ADMINISTRATIVE_DISTRICT_NAME("administrativeDistrictName"),
  LEGAL_DISTRICT_CODE("legalDistrictCode"),
  LEGAL_DISTRICT_NAME("legalDistrictName"),
  PARCEL_CODE("parcelCode"),
  LAND_CATEGORY_CODE("landCategoryCode"),
  LAND_CATEGORY_NAME("landCategoryName"),
  PARCEL_MAIN_NUMBER("parcelMainNumber"),
  PARCEL_SUB_NUMBER("parcelSubNumber"),
  PARCEL_ADDRESS("parcelAddress"),
  ROAD_CODE("roadCode"),
  ROAD_NAME("roadName"),
  BUILDING_MAIN_NUMBER("buildingMainNumber"),
  BUILDING_SUB_NUMBER("buildingSubNumber"),
  BUILDING_MANAGEMENT_NUMBER("buildingManagementNumber"),
  BUILDING_NAME("buildingName"),
  ROAD_ADDRESS("roadAddress"),
  OLD_ZIP_CODE("oldZipCode"),
  NEW_ZIP_CODE("newZipCode"),
  DONG_INFO("dongInfo"),
  FLOOR_INFO("floorInfo"),
  UNIT_INFO("unitInfo"),
  LONGITUDE("longitude"),
  LATITUDE("latitude");

  private String name;
}
