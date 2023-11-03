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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
