package com.functions.domain.model.gemini;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Candidate {
    private Content content;
    private String finishReason;
    private long index;
    private SafetyRating[] safetyRatings;

}
