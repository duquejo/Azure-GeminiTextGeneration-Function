package com.functions.domain.model;

import com.microsoft.azure.functions.HttpStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@ToString
@Builder
public class PromptResponse {

    private final Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
    private final String prompt;
    private final Object message;
    private final HttpStatus status;

    public PromptResponse(String prompt, Object message, HttpStatus status) {
        this.prompt = prompt;
        this.message = message;
        this.status = status;
    }
}
