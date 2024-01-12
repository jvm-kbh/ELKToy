package me.kbh.elktoy.commercial.dto.response.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class TotalDto {
  @JsonProperty("value")
  private int value;

  @JsonProperty("relation")
  private String relation;
}
