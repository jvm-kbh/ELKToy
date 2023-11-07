package me.kbh.elktoy.commercial.presentation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import me.kbh.elktoy.commercial.code.CommercialPropertyFieldCode;
import me.kbh.elktoy.commercial.dto.resposne.CommercialPropertyResponse;
import me.kbh.elktoy.commercial.service.CommercialPropertyCSVService;
import me.kbh.elktoy.commercial.service.CommercialPropertyService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/commercial-property")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CommercialPropertyController {

  CommercialPropertyService commercialPropertyService;
  CommercialPropertyCSVService commercialPropertyCSVService;

  @GetMapping("/{fieldCode}/{searchText}")
  public ResponseEntity<CommercialPropertyResponse> byField(
      @PathVariable CommercialPropertyFieldCode fieldCode, @PathVariable String searchText) {
    return ResponseEntity.ok(
        commercialPropertyService.findByFieldAndSearchText(fieldCode, searchText));
  }

  @PostMapping("/csv")
  @Operation(
      summary = "테스트파일 1000개 csv로 넣기",
      description = "* 테스트 파일을 넣습니다.",
      responses = {
        @ApiResponse(responseCode = "200", description = "성공"),
      })
  public ResponseEntity<Void> createDummyDataByCSV() {
    commercialPropertyCSVService.createDummyData();
    return ResponseEntity.noContent().build();
  }

  // 단순 테스트 후 삭제예정
  @GetMapping("/elasticsearch-get")
  @ResponseBody
  public String elasticsearchGet() {
    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<String> responseEntity =
        restTemplate.getForEntity("http://localhost:9200/_cat/indices", String.class);
    return responseEntity.getBody();
  }

  // 단순 테스트 후 삭제예정
  @GetMapping("/elasticsearch-post")
  public ResponseEntity<String> elasticsearchPost() {
    RestTemplate restTemplate = new RestTemplate();
    String elasticsearchUrl = "http://localhost:9200/commercial_property/_search";

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);

    String requestData =
        "{\"size\": 0, \"aggs\": {\"test\": {\"terms\": {\"field\": \"middleCategoryName.keyword\"}}}}";
    HttpEntity<String> requestEntity = new HttpEntity<>(requestData, headers);

    return restTemplate.postForEntity(elasticsearchUrl, requestEntity, String.class);
  }
}
