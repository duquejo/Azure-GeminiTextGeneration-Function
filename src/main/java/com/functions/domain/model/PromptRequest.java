package com.functions.domain.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class PromptRequest {
    @NotEmpty
    @NotNull
    private String text;
}
