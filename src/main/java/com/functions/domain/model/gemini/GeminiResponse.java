package com.functions.domain.model.gemini;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GeminiResponse {
    private Candidate[] candidates;
    private UsageMetadata usageMetadata;
}
