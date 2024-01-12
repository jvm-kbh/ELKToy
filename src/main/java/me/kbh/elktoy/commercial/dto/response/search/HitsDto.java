package me.kbh.elktoy.commercial.dto.response.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class HitsDto {
  @JsonProperty("total")
  private TotalDto total;

  @JsonProperty("max_score")
  private double maxScore;

  @JsonProperty("hits")
  private List<HitDto> hitDtoList;
}
