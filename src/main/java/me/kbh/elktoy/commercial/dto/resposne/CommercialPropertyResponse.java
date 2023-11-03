package me.kbh.elktoy.commercial.dto.resposne;

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

  @Builder
  public CommercialPropertyResponse(List<CommercialPropertyDto> commercialPropertyDtoList) {
    this.commercialPropertyDtoList = commercialPropertyDtoList;
  }
}
