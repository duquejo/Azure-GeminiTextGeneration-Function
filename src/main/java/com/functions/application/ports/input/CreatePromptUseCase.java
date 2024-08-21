package com.functions.application.ports.input;

import com.functions.domain.exception.InvalidConfigParameter;
import com.functions.domain.exception.ValidationException;
import com.functions.domain.model.PromptRequest;
import com.functions.domain.model.PromptResponse;

import java.io.IOException;

public interface CreatePromptUseCase {
    PromptResponse createPrompt(PromptRequest prompt) throws ValidationException, InvalidConfigParameter, IOException, InterruptedException;
}
