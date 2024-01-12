package me.kbh.elktoy.commercial.dto.response.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShardsDto {
  @JsonProperty("total")
  private int total;

  @JsonProperty("successful")
  private int successful;

  @JsonProperty("skipped")
  private int skipped;

  @JsonProperty("failed")
  private int failed;
}
