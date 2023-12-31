package me.kbh.elktoy.commercial.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.StreamSupport;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import me.kbh.elktoy.commercial.code.CommercialPropertyAPICode;
import me.kbh.elktoy.commercial.code.CommercialPropertyColumCode;
import me.kbh.elktoy.commercial.code.CommercialPropertyFieldCode;
import me.kbh.elktoy.commercial.component.RestComponent;
import me.kbh.elktoy.commercial.dto.CommercialPropertyDto;
import me.kbh.elktoy.commercial.dto.resposne.CommercialPropertyResponse;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CommercialPropertyServiceImpl implements CommercialPropertyService {

  RestComponent restComponent;
  ObjectMapper objectMapper;

  @Override
  public CommercialPropertyResponse findByFieldAndSearchText(
      CommercialPropertyFieldCode fieldCode, String searchText) {

    return CommercialPropertyResponse.builder().commercialPropertyDtoList(null).build();
  }

  @Override
  public CommercialPropertyResponse findAll(int from) {
    String jsonBody =
                      """
                        {
                          "from": %d,
                          "size": %d,
                          "_source": [ %s ]
                        }
                      """
            .formatted((from - 1) * 10, 10, CommercialPropertyColumCode.ALL.getColumString());

    String apiResult =
        restComponent.sendPostRequest(
            CommercialPropertyAPICode.SEARCH.getApiUrl(), jsonBody, String.class);

    List<LinkedHashMap<String, Object>> hitList;
    try {
      hitList =
          StreamSupport.stream(
                  objectMapper.readTree(apiResult).path("hits").path("hits").spliterator(), false)
              .map(hit -> hit.get("_source"))
              .filter(Objects::nonNull)
              .map(
                  source ->
                      objectMapper.convertValue(
                          source, new TypeReference<LinkedHashMap<String, Object>>() {}))
              .toList();
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }

    List<CommercialPropertyDto> commercialPropertyDtoList =
        hitList.stream()
            .map(data -> CommercialPropertyDto.builderByData().hitData(data).dataBuild())
            .toList();

    return CommercialPropertyResponse.builder()
        .commercialPropertyDtoList(commercialPropertyDtoList)
        .build();
  }

  @Override
  public long getDataTotalCount() {
    String apiResult =
        restComponent.sendGetRequest(
            CommercialPropertyAPICode.TOTAL_COUNT.getApiUrl(), String.class);

    try {
      JsonNode countNode = objectMapper.readTree(apiResult).get("count");
      return countNode.asLong();

    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }
}
