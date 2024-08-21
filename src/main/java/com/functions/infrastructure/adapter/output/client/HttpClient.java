package com.functions.infrastructure.adapter.output.client;

import java.net.URI;

public interface HttpClient {
    String invoke(URI url, Object payload);
}
