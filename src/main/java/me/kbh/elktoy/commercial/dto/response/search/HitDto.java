package me.kbh.elktoy.commercial.dto.response.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class HitDto {
  @JsonProperty("_index")
  private String index;

  @JsonProperty("_id")
  private String id;

  @JsonProperty("_score")
  private double score;

  @JsonProperty("_source")
  private HitSourceDto hitSourceDto;
}
