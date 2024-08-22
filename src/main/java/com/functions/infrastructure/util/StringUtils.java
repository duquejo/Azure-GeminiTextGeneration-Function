package com.functions.infrastructure.util;

import java.net.URI;

public class StringUtils {
    private StringUtils() {
    }
    public static URI simpleFormatUri(String baseUrl, String key) {
        return URI.create(String.format("%s?key=%s", baseUrl, key));
    }
}
