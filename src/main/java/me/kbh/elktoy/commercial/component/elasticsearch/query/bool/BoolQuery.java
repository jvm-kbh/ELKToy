package me.kbh.elktoy.commercial.component.elasticsearch.query.bool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.kbh.elktoy.commercial.component.elasticsearch.query.QueryBuilder;
import me.kbh.elktoy.commercial.component.elasticsearch.query.bool.template.BoolQueryTemplate;
import me.kbh.elktoy.commercial.dto.condition.CommercialPropertySearchCondition;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class BoolQuery extends QueryBuilder {
  String boolQuery = "";

  @Builder
  public BoolQuery(CommercialPropertySearchCondition condition) {
    String boolQuery = """
      "bool" : {%s}
    """;
    String filterTypeQuery = """
      "filter" : %s
    """;
    String mustTypeQuery = """
      "must" : %s
    """;

    Map<BoolQueryType, String> queryTemplateMap = new HashMap<>();

    List<String> mustQueryList = new ArrayList<>();
    List<String> filterQueryList = new ArrayList<>();

    boolean nameBuildCondition = !condition.isBlankSearchName();
    boolean geoBuildCondtion = !condition.isZeroLat() && !condition.isZeroLot();
    boolean categoryBuildCondition =
        !condition.isBlankCategoryType() && !condition.isBlankCategoryCode();

    if (nameBuildCondition) { putNameValue(condition, mustQueryList); }
    if (geoBuildCondtion) { putGeoValue(condition, filterQueryList); }
    if (categoryBuildCondition) { putCatetoryValue(condition, mustQueryList); }

    filterTypeQuery = mappingQueryTemplateAndValue(filterTypeQuery, filterQueryList);
    mustTypeQuery = mappingQueryTemplateAndValue(mustTypeQuery, mustQueryList);
    boolQuery = mappingBoolQueryRootTemplateAndValue(boolQuery, filterTypeQuery, mustTypeQuery);

    this.boolQuery = baseQuery.formatted(boolQuery);
  }

  private String mappingBoolQueryRootTemplateAndValue(
      String boolQuery, String filterTypeQuery, String mustTypeQuery) {
    List<String> boolQueryList = new ArrayList<>();
    boolQueryList.add(filterTypeQuery);
    boolQueryList.add(mustTypeQuery);

    String boolQueryValue = boolQueryList.stream().collect(Collectors.joining(", "));
    return boolQuery.formatted(boolQueryValue);
  }

  private String mappingQueryTemplateAndValue(
      String filterTypeQuery, List<String> filterQueryList) {
    String filterQueryValue = filterQueryList.stream().collect(Collectors.joining(", ", "[", "]"));
    filterTypeQuery = filterTypeQuery.formatted(filterQueryValue);
    return filterTypeQuery;
  }

  private void putCatetoryValue(
      CommercialPropertySearchCondition condition, List<String> mustQueryList) {
    String categoryTemplate = BoolQueryTemplate.CATEGORY.getTemplate();
    categoryTemplate =
        categoryTemplate.formatted(condition.getCategoryType(), condition.getCategoryCode());
    mustQueryList.add(categoryTemplate);
  }

  private void putGeoValue(
      CommercialPropertySearchCondition condition, List<String> filterQueryList) {
    String geoTemplate = BoolQueryTemplate.GEO.getTemplate();
    int distance = 10;
    geoTemplate = geoTemplate.formatted(distance, condition.getLat(), condition.getLot());
    filterQueryList.add(geoTemplate);
  }

  private void putNameValue(
      CommercialPropertySearchCondition condition, List<String> mustQueryList) {
    String nameTemplate = BoolQueryTemplate.NAME.getTemplate();
    nameTemplate = nameTemplate.formatted(condition.getSearchName());
    mustQueryList.add(nameTemplate);
  }
}
