package com.functions.infrastructure.adapter;

import java.net.URI;

public interface HttpClient {
    String invoke(URI url, Object payload);
}
