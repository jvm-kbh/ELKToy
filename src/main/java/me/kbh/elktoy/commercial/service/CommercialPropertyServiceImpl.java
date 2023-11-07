package me.kbh.elktoy.commercial.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import me.kbh.elktoy.commercial.code.CommercialPropertyFieldCode;
import me.kbh.elktoy.commercial.dto.resposne.CommercialPropertyResponse;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CommercialPropertyServiceImpl implements CommercialPropertyService {


  @Override
  public CommercialPropertyResponse findByFieldAndSearchText(
      CommercialPropertyFieldCode fieldCode, String searchText) {

    return CommercialPropertyResponse.builder()
        .commercialPropertyDtoList(null)
        .build();
  }
}
