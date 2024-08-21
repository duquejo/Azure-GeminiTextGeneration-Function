package com.functions.application.ports.input;

import com.functions.domain.exception.ValidationException;
import com.functions.domain.model.PromptRequest;
import com.functions.domain.model.PromptResponse;

public interface CreatePromptUseCase {
    PromptResponse createPrompt(PromptRequest prompt) throws ValidationException;
}
