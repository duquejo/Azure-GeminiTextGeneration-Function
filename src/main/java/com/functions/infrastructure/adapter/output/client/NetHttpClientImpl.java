package com.functions.infrastructure.adapter.output.client;

import static java.net.http.HttpRequest.BodyPublishers.ofString;

import com.functions.domain.model.gemini.GeminiResponse;
import com.functions.infrastructure.util.JsonUtils;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class NetHttpClientImpl implements HttpClient {

    private final java.net.http.HttpClient httpClient;

    public NetHttpClientImpl() {
        this.httpClient = java.net.http.HttpClient.newHttpClient();
    }

    @Override
    public GeminiResponse invoke(URI uri, Object payload) throws IOException, InterruptedException {
            String strPayload = JsonUtils.objectAsAString(payload);
            HttpRequest request = buildRequest(uri, strPayload);
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            String body = response.body();

            return JsonUtils.stringAsObject(body);
    }

    private HttpRequest buildRequest(URI uri, String strBody) {
        return HttpRequest
            .newBuilder()
            .uri(uri)
            .POST(ofString(strBody))
            .header("Content-Type", "application/json")
            .build();
    }
}
