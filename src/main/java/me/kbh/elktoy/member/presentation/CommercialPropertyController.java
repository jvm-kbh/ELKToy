package me.kbh.elktoy.member.presentation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import me.kbh.elktoy.member.service.CommercialPropertyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/commercial-property")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CommercialPropertyController {

  CommercialPropertyService commercialPropertyService;

  @PostMapping("/csv")
  @Operation(
      summary = "테스트파일 1000개 csv로 넣기",
      description = "* 테스트 파일을 넣습니다.",
      responses = {
          @ApiResponse(responseCode = "200", description = "성공"),
      }
  )
  public ResponseEntity<Void> createDummyDataByCSV() {
    commercialPropertyService.createDummyData();
    return ResponseEntity.noContent().build();
  }
}
