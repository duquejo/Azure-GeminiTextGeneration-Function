package com.functions.domain.service;

import com.functions.application.factory.PromptFactory;
import com.functions.infrastructure.adapter.HttpClient;

import java.net.URI;
import java.util.Map;

public class PromptServiceImpl implements PromptService {

    private final HttpClient httpClient;
    private final String apiKey = System.getenv("GEMINI_API_KEY");
    private final String url = System.getenv("GEMINI_URL");

    public PromptServiceImpl(HttpClient client) {
        this.httpClient = client;
    }

    public String execute(String text) {
        URI uri = URI.create(String.format("%s?key=%s", url, apiKey));
        Map<String, Object> payload = PromptFactory.create(text);
        return httpClient.invoke(uri, payload);
    }
}
