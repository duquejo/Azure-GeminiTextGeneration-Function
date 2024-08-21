package com.functions.domain.model.gemini;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SafetyRating {
    private String category;
    private String probability;
}
