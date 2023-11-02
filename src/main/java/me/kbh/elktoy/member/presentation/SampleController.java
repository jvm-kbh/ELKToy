package me.kbh.elktoy.member.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleController {

  @GetMapping("/sample")
  public String samplePage() {
    return "sample";
  }
}
