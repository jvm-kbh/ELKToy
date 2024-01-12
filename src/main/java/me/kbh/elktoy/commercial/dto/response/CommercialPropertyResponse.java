package me.kbh.elktoy.commercial.dto.response;

import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import me.kbh.elktoy.commercial.dto.CommercialPropertyDto;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommercialPropertyResponse {
  List<CommercialPropertyDto> commercialPropertyDtoList;
  int count;

  @Builder
  public CommercialPropertyResponse(
      List<CommercialPropertyDto> commercialPropertyDtoList, int count) {
    this.commercialPropertyDtoList = commercialPropertyDtoList;
    this.count = count;
  }
}
