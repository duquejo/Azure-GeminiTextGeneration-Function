package com.functions.domain.factory;

import java.util.Map;

public interface PromptFactory {
    Map<String, Object> create(String text);
}
