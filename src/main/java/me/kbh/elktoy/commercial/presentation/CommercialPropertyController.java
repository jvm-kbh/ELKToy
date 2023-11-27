package me.kbh.elktoy.commercial.presentation;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import me.kbh.elktoy.commercial.dto.condition.CommercialPropertySearchCondition;
import me.kbh.elktoy.commercial.dto.resposne.CommercialPropertyAggregationResponse;
import me.kbh.elktoy.commercial.dto.resposne.CommercialPropertyResponse;
import me.kbh.elktoy.commercial.service.CommercialPropertyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/commercial-property")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CommercialPropertyController {

  CommercialPropertyService commercialPropertyService;

  @GetMapping("/count")
  public ResponseEntity<Long> count() {
    return ResponseEntity.ok(commercialPropertyService.getDataTotalCount());
  }

  @GetMapping("/all/{from}")
  public ResponseEntity<CommercialPropertyResponse> findAll(@PathVariable int from) {
    return ResponseEntity.ok(commercialPropertyService.findAll(from));
  }

  @GetMapping("/aggregation-list")
  public ResponseEntity<CommercialPropertyAggregationResponse> getAggregationList() {
    return ResponseEntity.ok(commercialPropertyService.getAggregationList());
  }

  @GetMapping("/all")
  public ResponseEntity<CommercialPropertyResponse> findAllByCondition(
      @ModelAttribute CommercialPropertySearchCondition condition) {

    return ResponseEntity.ok(commercialPropertyService.findAllByCondition(condition));
  }
}
