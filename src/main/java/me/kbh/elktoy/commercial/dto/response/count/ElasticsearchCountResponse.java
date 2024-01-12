package me.kbh.elktoy.commercial.dto.response.count;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import me.kbh.elktoy.commercial.dto.response.common.ShardsDto;

@Getter
public class ElasticsearchCountResponse {

  @JsonProperty("count")
  private int count;

  @JsonProperty("_shards")
  private ShardsDto shards;

}
