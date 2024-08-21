package com.functions.infrastructure.adapter.input;

import com.functions.application.ports.input.CreatePromptUseCase;
import com.functions.domain.exception.InvalidConfigParameter;
import com.functions.domain.exception.ValidationException;
import com.functions.domain.model.PromptRequest;
import com.functions.domain.model.PromptResponse;
import lombok.RequiredArgsConstructor;

import java.io.IOException;

@RequiredArgsConstructor
public class FunctionInputAdapter {

    private final CreatePromptUseCase createPromptUseCase;

    public PromptResponse execute(PromptRequest request) throws ValidationException, InvalidConfigParameter, IOException, InterruptedException {
        return createPromptUseCase.createPrompt(request);
    }
}
