package me.kbh.elktoy.commercial.dto.condition;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class CommercialPropertySearchCondition {
  String searchName;
  Double lat;
  Double lot;
  Integer from;
  String categoryType;
  String categoryCode;

  public boolean isBlankSearchName() {
    return this.searchName.isBlank();
  }

  public boolean isZeroLat() {
    return this.lat.equals(0D);
  }

  public boolean isZeroLot() {
    return this.lot.equals(0D);
  }

  public boolean isZeroFrom() {
    return this.from.equals(0);
  }

  public boolean isBlankCategoryType() {
    return this.categoryType.isBlank();
  }

  public boolean isBlankCategoryCode() {
    return this.categoryCode.isBlank();
  }
}
