package me.kbh.elktoy.commercial.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import me.kbh.elktoy.commercial.code.CommercialPropertyAPICode;
import me.kbh.elktoy.commercial.code.CommercialPropertyColumCode;
import me.kbh.elktoy.commercial.code.CommercialPropertyFieldCode;
import me.kbh.elktoy.commercial.component.RestComponent;
import me.kbh.elktoy.commercial.component.elasticsearch.ElasticsearchRequestBuilder;
import me.kbh.elktoy.commercial.component.elasticsearch.query.QueryBuilder;
import me.kbh.elktoy.commercial.component.elasticsearch.query.QueryType;
import me.kbh.elktoy.commercial.component.elasticsearch.query.bool.BoolQuery.BoolQueryBuilder;
import me.kbh.elktoy.commercial.dto.CommercialPropertyDto;
import me.kbh.elktoy.commercial.dto.aggregation.CommercialPropertyAggregation;
import me.kbh.elktoy.commercial.dto.condition.CommercialPropertySearchCondition;
import me.kbh.elktoy.commercial.dto.response.CommercialPropertyResponse;
import me.kbh.elktoy.commercial.dto.response.aggregation.CommercialPropertyAggregationResponse;
import me.kbh.elktoy.commercial.dto.response.count.ElasticsearchCountResponse;
import me.kbh.elktoy.commercial.dto.response.search.ElasticsearchSearchResponse;
import me.kbh.elktoy.commercial.dto.response.search.HitSourceDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

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
                  objectMapper.readTree(apiResult).get("hits").get("hits").spliterator(), false)
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
        restComponent.sendGetRequest(CommercialPropertyAPICode.COUNT.getApiUrl(), String.class);

    try {
      JsonNode countNode = objectMapper.readTree(apiResult).get("count");
      return countNode.asLong();

    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public CommercialPropertyAggregationResponse getAggregationList() {
    String jsonBody =
        """
        {
          "size": 0,
          "aggs": {
            "majorCategoryNameAggregation": {
              "terms": {
                "field": "majorCategoryName.keyword",
                "size": 10
              },
              "aggs": {
                "code": {
                  "terms": {
                    "field": "majorCategoryCode"
                  }
                }
              }
            },
            "middleCategoryNameAggregation": {
              "terms": {
                "field": "middleCategoryName.keyword",
                "size": 10
              },
              "aggs": {
                "code": {
                  "terms": {
                    "field": "middleCategoryCode"
                  }
                }
              }
            },
            "subCategoryNameAggregation": {
              "terms": {
                "field": "subCategoryName.keyword",
                "size": 10
              },
              "aggs": {
                "code": {
                  "terms": {
                    "field": "subCategoryCode"
                  }
                }
              }
            }
          }
        }""";
    String apiResult =
        restComponent.sendPostRequest(
            CommercialPropertyAPICode.SEARCH.getApiUrl(), jsonBody, String.class);

    List<Map<String, String>> major = processCategoryAggregation(apiResult, "major");
    List<Map<String, String>> middle = processCategoryAggregation(apiResult, "middle");
    List<Map<String, String>> sub = processCategoryAggregation(apiResult, "sub");

    CommercialPropertyAggregation majorCommercialPropertyAggregation =
        CommercialPropertyAggregation.builder()
            .aggregationTitle("major")
            .aggregationDataMap(major)
            .build();
    CommercialPropertyAggregation middleCommercialPropertyAggregation =
        CommercialPropertyAggregation.builder()
            .aggregationTitle("middle")
            .aggregationDataMap(middle)
            .build();
    CommercialPropertyAggregation subCommercialPropertyAggregation =
        CommercialPropertyAggregation.builder()
            .aggregationTitle("sub")
            .aggregationDataMap(sub)
            .build();

    List<CommercialPropertyAggregation> commercialPropertyAggregationList =
        List.of(
            majorCommercialPropertyAggregation,
            middleCommercialPropertyAggregation,
            subCommercialPropertyAggregation);

    return CommercialPropertyAggregationResponse.builder()
        .commercialPropertyAggregationList(commercialPropertyAggregationList)
        .build();
  }

  @Override
  public CommercialPropertyResponse findAllByCondition(
      CommercialPropertySearchCondition condition) {

    String elasticsearchUrl = "http://localhost:9200";
    String query = buildQueryFromCondition(condition);

    String requestBaseBody = getRequestBaseBody(condition, query);
    ResponseEntity<ElasticsearchSearchResponse> searchApiResponse =
        getSearchApiRespose(elasticsearchUrl, requestBaseBody);
    List<HitSourceDto> documentData = searchApiResponse.getBody().getDocumentData();

    ResponseEntity<ElasticsearchCountResponse> countApiResponse =
        getCountApiResponse(elasticsearchUrl, query);
    int countByCondition = countApiResponse.getBody().getCount();

    return getCommercialPropertyResponse(documentData, countByCondition);
  }

  private static CommercialPropertyResponse getCommercialPropertyResponse(
      List<HitSourceDto> documentData, int countByCondition) {
    List<CommercialPropertyDto> commercialPropertyDtoList =
        documentData.stream().map(CommercialPropertyDto::new).collect(Collectors.toList());

    return CommercialPropertyResponse.builder()
        .commercialPropertyDtoList(commercialPropertyDtoList)
        .count(countByCondition)
        .build();
  }

  private static ResponseEntity<ElasticsearchCountResponse> getCountApiResponse(
      String elasticsearchUrl, String query) {
    RestClient restClient =
        RestClient.builder()
            .baseUrl(elasticsearchUrl + CommercialPropertyAPICode.COUNT.getApiUrl())
            .build();

    String wrapJsonRootForQuery = "{%s}".formatted(query);

    return restClient
        .post()
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON)
        .body(wrapJsonRootForQuery)
        .retrieve()
        .toEntity(ElasticsearchCountResponse.class);
  }

  private static ResponseEntity<ElasticsearchSearchResponse> getSearchApiRespose(
      String elasticsearchUrl, String requestBaseBody) {

    RestClient restClient =
        RestClient.builder()
            .baseUrl(elasticsearchUrl + CommercialPropertyAPICode.SEARCH.getApiUrl())
            .build();
    return restClient
        .post()
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON)
        .body(requestBaseBody)
        .retrieve()
        .toEntity(ElasticsearchSearchResponse.class);
  }

  private static String getRequestBaseBody(
      CommercialPropertySearchCondition condition, String query) {
    return ElasticsearchRequestBuilder.builder()
        .from(condition.getFrom())
        .size(10)
        .source(CommercialPropertyColumCode.ALL.getColumString())
        .query(query)
        .build()
        .buildJsonBody();
  }

  private static String buildQueryFromCondition(CommercialPropertySearchCondition condition) {
    BoolQueryBuilder boolQueryBuilder = QueryBuilder.chooseType(QueryType.BOOL);
    String query = boolQueryBuilder.condition(condition).build().getBoolQuery();
    return query;
  }

  private List<Map<String, String>> processCategoryAggregation(String apiResult, String type) {
    Spliterator<JsonNode> bucketSpliterator;
    try {
      bucketSpliterator =
          objectMapper
              .readTree(apiResult)
              .get("aggregations")
              .get(type + "CategoryNameAggregation")
              .get("buckets")
              .spliterator();
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }

    return StreamSupport.stream(bucketSpliterator, false)
        .filter(Objects::nonNull)
        .map(
            bucket -> {
              // Create a map to store "key", "doc_count", and "buckets.key" values
              Map<String, String> bucketMap = new LinkedHashMap<>();
              bucketMap.put("key", String.valueOf(bucket.get("key")));
              bucketMap.put("count", String.valueOf(bucket.get("doc_count")));

              JsonNode codeNode = bucket.get("code");
              if (codeNode != null && codeNode.has("buckets")) {
                JsonNode subBuckets = codeNode.get("buckets");
                if (subBuckets.isArray() && subBuckets.size() > 0) {
                  bucketMap.put("code", String.valueOf(subBuckets.get(0).get("key")));
                }
              }

              return bucketMap;
            })
        .collect(Collectors.toList());
  }
}
