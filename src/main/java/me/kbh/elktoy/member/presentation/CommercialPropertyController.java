package me.kbh.elktoy.member.presentation;

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
  public ResponseEntity<Void> createDummyDataByCSV() {
    commercialPropertyService.createDummyData();
    return ResponseEntity.noContent().build();
  }
}
