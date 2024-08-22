package com.functions.infrastructure.adapter.output.client;

import com.functions.domain.model.gemini.GeminiResponse;

import java.io.IOException;
import java.net.URI;

public interface HttpClient {
    GeminiResponse invoke(URI url, Object payload) throws IOException, InterruptedException;
}
