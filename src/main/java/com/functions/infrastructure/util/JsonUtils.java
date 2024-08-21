package com.functions.infrastructure.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.functions.domain.model.gemini.GeminiResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JsonUtils {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String objectAsAString(Object payload) throws JsonProcessingException {
        return objectMapper.writeValueAsString(payload);
    }

    public static GeminiResponse stringAsObject(String payload) throws JsonProcessingException {
        return objectMapper.readValue(payload, GeminiResponse.class);
    }
}
