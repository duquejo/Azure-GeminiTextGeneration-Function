package com.functions.infrastructure.adapter.nethttpclient;

import com.functions.infrastructure.adapter.HttpClient;
import com.functions.infrastructure.adapter.HttpClientFactory;

public class NetHttpClientFactory implements HttpClientFactory {
    @Override
    public HttpClient create() {
        return new NetHttpClientImpl();
    }
}
