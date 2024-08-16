package com.functions.domain.model;

import java.util.Map;

public class TextModel {
    private final String content;

    public TextModel(String content) {
        this.content = content;
    }

    public String content() {
        return content;
    }

    public Map<String, String> toMap() {
        return Map.of("text", content);
    }
}
