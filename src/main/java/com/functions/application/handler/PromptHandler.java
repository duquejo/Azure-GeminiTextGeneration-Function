package com.functions.application.handler;

import com.functions.domain.service.PromptService;

public class PromptHandler {
    private final PromptService service;

    public PromptHandler(PromptService service) {
        this.service = service;
    }

    public String execute(String search) {
        return service.execute(search);
    }
}
