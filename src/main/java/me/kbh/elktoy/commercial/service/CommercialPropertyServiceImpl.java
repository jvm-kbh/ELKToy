package me.kbh.elktoy.commercial.service;

import java.util.List;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import me.kbh.elktoy.commercial.code.CommercialPropertyFieldCode;
import me.kbh.elktoy.commercial.model.CommercialProperty;
import me.kbh.elktoy.commercial.dto.CommercialPropertyDto;
import me.kbh.elktoy.commercial.dto.resposne.CommercialPropertyResponse;
import me.kbh.elktoy.commercial.repository.CommercialPropertyRepository;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CommercialPropertyServiceImpl implements CommercialPropertyService {

  ElasticsearchOperations operations;
  CommercialPropertyRepository commercialPropertyRepository;

  @Override
  public CommercialPropertyResponse findByFieldAndSearchText(
      CommercialPropertyFieldCode fieldCode, String searchText) {

    Criteria criteria = new Criteria(fieldCode.getName()).is(searchText);
    Query searchQuery = new CriteriaQuery(criteria);

    List<CommercialPropertyDto> commercialPropertyDtoList =
        operations.search(searchQuery, CommercialProperty.class).stream()
            .map(SearchHit::getContent)
            .map(CommercialPropertyDto::new)
            .toList();

    return CommercialPropertyResponse.builder()
        .commercialPropertyDtoList(commercialPropertyDtoList)
        .build();
  }
}
