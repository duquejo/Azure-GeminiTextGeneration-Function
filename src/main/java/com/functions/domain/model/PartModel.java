package com.functions.domain.model;


import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class PartModel {
    private final List<TextModel> parts;

    public List<Map<String, String>> getParts() {
        return parts
            .stream()
            .map(TextModel::toMap)
            .toList();
    }

    public Map<String, List<Map<String, String>>> toMap() {
        return Map.of("parts", getParts());
    }
}
