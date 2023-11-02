package me.kbh.elktoy.member.entity;

import lombok.Builder;
import lombok.Getter;
import org.apache.commons.csv.CSVRecord;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Mapping;

@Getter
@Document(indexName = "commercial_property")
@Mapping(mappingPath = "elasticsearch/mapping/commercial_property_mapping.json")
public class CommercialProperty {
  @Id String commercialPropertyId; // 상가업소번호, 이 엔티티의 기본 키
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
  public CommercialProperty(CSVRecord csvRecord) {
    this.commercialPropertyId = csvRecord.get("\uFEFFcommercialPropertyId");
    this.name = csvRecord.get("name");
    this.branchName = csvRecord.get("branchName");
    this.majorCategoryCode = csvRecord.get("majorCategoryCode");
    this.majorCategoryName = csvRecord.get("majorCategoryName");
    this.middleCategoryCode = csvRecord.get("middleCategoryCode");
    this.middleCategoryName = csvRecord.get("middleCategoryName");
    this.subCategoryCode = csvRecord.get("subCategoryCode");
    this.subCategoryName = csvRecord.get("subCategoryName");
    this.industryCode = csvRecord.get("industryCode");
    this.industryName = csvRecord.get("industryName");
    this.cityCode = csvRecord.get("cityCode");
    this.cityName = csvRecord.get("cityName");
    this.districtCode = csvRecord.get("districtCode");
    this.districtName = csvRecord.get("districtName");
    this.administrativeDistrictCode = csvRecord.get("administrativeDistrictCode");
    this.administrativeDistrictName = csvRecord.get("administrativeDistrictName");
    this.legalDistrictCode = csvRecord.get("legalDistrictCode");
    this.legalDistrictName = csvRecord.get("legalDistrictName");
    this.parcelCode = csvRecord.get("parcelCode");
    this.landCategoryCode = csvRecord.get("landCategoryCode");
    this.landCategoryName = csvRecord.get("landCategoryName");
    this.parcelMainNumber = csvRecord.get("parcelMainNumber").isBlank() ? 0 : Integer.parseInt(csvRecord.get("parcelMainNumber"));
    this.parcelSubNumber = csvRecord.get("parcelSubNumber").isBlank() ? 0 : Integer.parseInt(csvRecord.get("parcelSubNumber"));
    this.parcelAddress = csvRecord.get("parcelAddress");
    this.roadCode = csvRecord.get("roadCode");
    this.roadName = csvRecord.get("roadName");
    this.buildingMainNumber = csvRecord.get("buildingMainNumber").isBlank() ? 0 : Integer.parseInt(csvRecord.get("buildingMainNumber"));
    this.buildingSubNumber = csvRecord.get("buildingSubNumber").isBlank() ? 0 : Integer.parseInt(csvRecord.get("buildingSubNumber"));
    this.buildingManagementNumber = csvRecord.get("buildingManagementNumber");
    this.buildingName = csvRecord.get("buildingName");
    this.roadAddress = csvRecord.get("roadAddress");
    this.oldZipCode = csvRecord.get("oldZipCode");
    this.newZipCode = csvRecord.get("newZipCode");
    this.dongInfo = csvRecord.get("dongInfo");
    this.floorInfo = csvRecord.get("floorInfo");
    this.unitInfo = csvRecord.get("unitInfo");
    this.longitude = csvRecord.get("longitude").isBlank() ? 0D : Double.parseDouble(csvRecord.get("longitude"));
    this.latitude = csvRecord.get("latitude").isBlank() ? 0D : Double.parseDouble(csvRecord.get("latitude"));
  }
}
