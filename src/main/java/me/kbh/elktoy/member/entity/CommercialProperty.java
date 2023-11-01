package me.kbh.elktoy.member.entity;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

@Builder
@Getter
@Document(indexName = "commercial_property")
public class CommercialProperty {
  @Id private Long commercialPropertyId;                      // 상가업소번호, 이 엔티티의 기본 키
  @Field private String name;                                 // 상호명
  @Field private String branchName;                           // 지점명
  @Field private String majorCategoryCode;                    // 상권업종대분류코드
  @Field private String majorCategoryName;                    // 상권업종대분류명
  @Field private String middleCategoryCode;                   // 상권업종중분류코드
  @Field private String middleCategoryName;                   // 상권업종중분류명
  @Field private String subCategoryCode;                      // 상권업종소분류코드
  @Field private String subCategoryName;                      // 상권업종소분류명
  @Field private String industryCode;                         // 표준산업분류코드
  @Field private String industryName;                         // 표준산업분류명
  @Field private String cityCode;                             // 시도코드
  @Field private String cityName;                             // 시도명
  @Field private String districtCode;                         // 시군구코드
  @Field private String districtName;                         // 시군구명
  @Field private String administrativeDistrictCode;           // 행정동코드
  @Field private String administrativeDistrictName;           // 행정동명
  @Field private String legalDistrictCode;                    // 법정동코드
  @Field private String legalDistrictName;                    // 법정동명
  @Field private String parcelCode;                           // 지번코드
  @Field private String landCategoryCode;                     // 대지구분코드
  @Field private String landCategoryName;                     // 대지구분명
  @Field private int parcelMainNumber;                        // 지번본번지
  @Field private int parcelSubNumber;                         // 지번부번지
  @Field private String parcelAddress;                        // 지번주소
  @Field private String roadCode;                             // 도로명코드
  @Field private String roadName;                             // 도로명
  @Field private int buildingMainNumber;                      // 건물본번지
  @Field private int buildingSubNumber;                       // 건물부번지
  @Field private String buildingManagementNumber;             // 건물관리번호
  @Field private String buildingName;                         // 건물명
  @Field private String roadAddress;                          // 도로명주소
  @Field private String oldZipCode;                           // 구우편번호
  @Field private String newZipCode;                           // 신우편번호
  @Field private String dongInfo;                             // 동정보
  @Field private int floorInfo;                               // 층정보
  @Field private String unitInfo;                             // 호정보
  @Field private double longitude;                            // 경도
  @Field private double latitude;                             // 위도
}
