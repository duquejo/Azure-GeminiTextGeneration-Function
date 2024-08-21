package com.functions.domain.model;

import com.microsoft.azure.functions.HttpStatus;
import lombok.Getter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@ToString
public class PromptResponse {

    private final Timestamp timeStamp;
    private final String prompt;
    private final Object message;
    private final HttpStatus status;

    public PromptResponse(String prompt, Object message, HttpStatus status) {
        this.timeStamp = new Timestamp(System.currentTimeMillis());
        this.prompt = prompt;
        this.message = message;
        this.status = status;
    }
}
