package com.functions.infrastructure.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class JsonUtilities {
    private JsonUtilities() {}

    public static String objectAsAString(Object payload) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(payload);
    }
}
