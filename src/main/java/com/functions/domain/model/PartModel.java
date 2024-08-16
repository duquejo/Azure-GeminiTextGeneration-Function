package com.functions.domain.model;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartModel {
    private final List<TextModel> parts;

    public PartModel(List<TextModel> parts) {
        this.parts = parts;
    }

    public List<Map<String, String>> getParts() {
        return parts
            .stream()
            .map(TextModel::toMap)
            .collect(Collectors.toList());
    }

    public Map<String, List<Map<String, String>>> toMap() {
        return Map.of("parts", getParts());
    }
}
