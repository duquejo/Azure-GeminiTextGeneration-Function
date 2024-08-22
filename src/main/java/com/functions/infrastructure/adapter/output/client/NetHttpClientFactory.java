package com.functions.infrastructure.adapter.output.client;

public class NetHttpClientFactory implements HttpClientFactory {
    @Override
    public HttpClient create() {
        return new NetHttpClientImpl();
    }
}
