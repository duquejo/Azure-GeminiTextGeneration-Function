package com.functions.infrastructure.adapter.input;

import com.functions.application.ports.input.CreatePromptUseCase;
import com.functions.domain.exception.MisconfigurationException;
import com.functions.domain.exception.ValidationException;
import com.functions.domain.model.PromptRequest;
import com.functions.domain.model.PromptResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PromptRestAdapter {

    private final CreatePromptUseCase createPromptUseCase;

    public PromptResponse execute(PromptRequest request) throws ValidationException, MisconfigurationException {
        return createPromptUseCase.createPrompt(request);
    }
}
