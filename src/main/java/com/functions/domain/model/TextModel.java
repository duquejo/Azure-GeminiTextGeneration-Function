package com.functions.domain.model;

import java.util.Map;

public record TextModel(String content) {
    public Map<String, String> toMap() {
        return Map.of("text", content);
    }
}
