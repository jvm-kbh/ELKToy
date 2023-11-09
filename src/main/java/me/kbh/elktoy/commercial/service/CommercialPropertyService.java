package me.kbh.elktoy.commercial.service;

import me.kbh.elktoy.commercial.code.CommercialPropertyFieldCode;
import me.kbh.elktoy.commercial.dto.resposne.CommercialPropertyResponse;

public interface CommercialPropertyService {
  CommercialPropertyResponse findByFieldAndSearchText(
      CommercialPropertyFieldCode fieldCode, String searchText);

  CommercialPropertyResponse findAll(int from);

  long getDataTotalCount();
}
