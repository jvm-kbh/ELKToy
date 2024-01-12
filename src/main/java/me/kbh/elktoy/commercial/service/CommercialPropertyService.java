package me.kbh.elktoy.commercial.service;

import me.kbh.elktoy.commercial.code.CommercialPropertyFieldCode;
import me.kbh.elktoy.commercial.dto.condition.CommercialPropertySearchCondition;
import me.kbh.elktoy.commercial.dto.response.CommercialPropertyResponse;
import me.kbh.elktoy.commercial.dto.response.aggregation.CommercialPropertyAggregationResponse;

public interface CommercialPropertyService {

  CommercialPropertyResponse findByFieldAndSearchText(
      CommercialPropertyFieldCode fieldCode, String searchText);

  CommercialPropertyResponse findAll(int from);

  long getDataTotalCount();

  CommercialPropertyAggregationResponse getAggregationList();

  CommercialPropertyResponse findAllByCondition(CommercialPropertySearchCondition condition);
}
