package com.functions.domain.model;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class ContentModel {
    private final List<PartModel> contents;

    public List<Map<String, List<Map<String, String>>>> getContents() {
        return contents
            .stream()
            .map(PartModel::toMap)
            .toList();
    }

    public Map<String, List<Map<String, List<Map<String, String>>>>> toMap() {
        return Map.of("contents", getContents());
    }
}
