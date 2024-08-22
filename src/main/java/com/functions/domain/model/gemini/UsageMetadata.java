package com.functions.domain.model.gemini;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UsageMetadata {
    private long promptTokenCount;
    private long candidatesTokenCount;
    private long totalTokenCount;
}
