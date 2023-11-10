package me.kbh.elktoy.commercial.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CommercialPropertyColumCode {
  ALL("""
      "commercialPropertyId",
      "name",
      "branchName",
      "majorCategoryCode",
      "majorCategoryName",
      "middleCategoryCode",
      "middleCategoryName",
      "subCategoryCode",
      "subCategoryName",
      "industryCode",
      "industryName",
      "cityCode",
      "cityName",
      "districtCode",
      "districtName",
      "administrativeDistrictCode",
      "administrativeDistrictName",
      "legalDistrictCode",
      "legalDistrictName",
      "parcelCode",
      "landCategoryCode",
      "landCategoryName",
      "parcelMainNumber",
      "parcelSubNumber",
      "parcelAddress",
      "roadCode",
      "roadName",
      "buildingMainNumber",
      "buildingSubNumber",
      "buildingManagementNumber",
      "buildingName",
      "roadAddress",
      "oldZipCode",
      "newZipCode",
      "dongInfo",
      "floorInfo",
      "unitInfo",
      "longitude",
      "latitude"
  """);
  private final String columString;
}
