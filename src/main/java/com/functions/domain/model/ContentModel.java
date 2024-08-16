package com.functions.domain.model;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ContentModel {
    private final List<PartModel> contents;

    public ContentModel(List<PartModel> contents) {
        this.contents = contents;
    }

    public List<Map<String, List<Map<String, String>>>> getContents() {
        return contents
            .stream()
            .map(PartModel::toMap)
            .collect(Collectors.toList());
    }

    public Map<String, List<Map<String, List<Map<String, String>>>>> toMap() {
        return Map.of("contents", getContents());
    }
}
