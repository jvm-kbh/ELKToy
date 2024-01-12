package me.kbh.elktoy.commercial.advice;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

/** requestDirectFieldAccessBinder : HTTP Get Request시 해당 조건 DTO의 setter 제거 */
@ControllerAdvice
public class ApplicationControllerAdvice {

  @InitBinder
  public void requestDirectFieldAccessBinder(WebDataBinder binder) {
    binder.initDirectFieldAccess();
  }
}
