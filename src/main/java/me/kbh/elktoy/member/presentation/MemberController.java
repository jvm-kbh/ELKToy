package me.kbh.elktoy.member.presentation;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import me.kbh.elktoy.member.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/user")
public class MemberController {

  MemberService memberService;

  @PostMapping("/100-user")
  public ResponseEntity<Void> byFakerLimit() {
    memberService.createUserByFakerLimit100();
    return ResponseEntity.noContent().build();
  }

  @GetMapping("all")
  public ResponseEntity<Void> findAll() {
    memberService.findAll();
    return ResponseEntity.noContent().build();
  }
}
