package me.kbh.elktoy.commercial.dto.response.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.Setter;
import me.kbh.elktoy.commercial.dto.response.common.ShardsDto;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ElasticsearchSearchResponse {
    @JsonProperty("took")
    private int took;

    @JsonProperty("timed_out")
    private boolean timedOut;

    @JsonProperty("_shards")
    private ShardsDto shardsDto;

    @JsonProperty("hits")
    private HitsDto hitsDto;

    public List<HitSourceDto> getDocumentData(){
        return this.hitsDto.getHitDtoList().stream()
            .map(HitDto::getHitSourceDto)
            .collect(Collectors.toList());
    }
}