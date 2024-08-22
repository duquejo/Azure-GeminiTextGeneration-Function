package com.functions.domain.model.gemini;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Content {
    private Part[] parts;
    private String role;
}
