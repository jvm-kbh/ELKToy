package me.kbh.elktoy.commercial.component.elasticsearch.query;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum QueryType {
    BOOL("bool");

    private String name;
}